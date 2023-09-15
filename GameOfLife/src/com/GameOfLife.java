package com;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
        boolean RequiredExit = false;
        while (true) {
            try {
                displayGameIntroduction(); //To display the Game Introduction
                System.out.println('\n' + "Please Enter Your Choice");
                int choice = 0;
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        displayGameOverview(); // To display Game Overview
                        break;
                    case 2:
                        startTheGame(scanner); //To start the Game
                        break;
                    case 3:
                        RequiredExit = true;
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter Number");
                continue;
            }
            if (RequiredExit) {
                break;
            }
        }
        System.out.println("End of The Game of Life");
    }
    static void displayGameIntroduction() {
        System.out.println("\n" + "---------------------------");
        System.out.println("\u001B[1m" + "\u001B[34m" + "Welcome to the Game of Life" + "\u001B[0m");
        System.out.println("---------------------------");
        System.out.println("1. Overview of the Game");
        System.out.println("2. Play the Game");
        System.out.println("3. Exit");
    }
    static void displayGameOverview() {
        String text = '\n' + "Overview of the Game of Life:" +
            '\n' + " " +
            '\n' + "The Game of Life, conceived by mathematician John Conway, is a cellular automaton game where cells can reproduce,vanish, or persist based on specific rules." +
            '\n' + "Played on a grid of squares of arbitrary size, each cell interacts with its eight neighboring squares." +
            '\n' + " " +
            '\n' + "The rules are as follows:" +
            '\n' + " " +
            '\n' + "\u001B[1m" + "1.Survival:" + "\u001B[0m" + "Cells with two or three adjacent cells survive to the next generation." +
            '\n' + " " +
            '\n' + "\u001B[1m" + "2.Death:" + "\u001B[0m" + "Cells with at least four adjacent cells die due to overpopulation, and those with at most one adjacent cell die due to isolation." +
            '\n' + " " +
            '\n' + "\u001B[1m" + "3.Birth:" + "\u001B[0m" + "Empty squares (dead cells) adjacent to exactly three cells give birth to a new cell in the next generation." +
            '\n' + " " +
            '\n' + "All births and deaths happen simultaneously during each generation." +
            '\n' + "This zero-player game showcases how simple rules can lead to complex and evolving patterns in a grid-based world." + '\n';
        System.out.print(text);
    }
    static void startTheGame(Scanner scanner) {
        System.out.println("Enter the Grid Dimensions");
        int userInputRows = 0, userInputColumns = 0;
        userInputRows = scanner.nextInt();
        userInputColumns = scanner.nextInt();

        if (userInputRows == 0 || userInputColumns == 0) {
            System.out.println("The Input Values are Invalid. Please Enter the Values Greater than Zero");
            return;
        }
        System.out.println('\n' + "You are Using " + userInputRows + "X" + userInputColumns + " Grid for the Game");
        int gridRows = userInputRows + 2;
        int gridColumns = userInputColumns + 2;

        int grid[][] = new int[gridRows][gridColumns];
        int future[][] = new int[gridRows][gridColumns];
        initializeGridRandomly(grid, gridRows, gridColumns);
        int generationNumber = 1;
        boolean result = true;
        System.out.println('\n' + "Generation " + generationNumber);
        printGrid(grid, gridRows, gridColumns);
        while (result) {
            for (int[] row: future) {
                Arrays.fill(row, 0);
            }
            generationNumber++;
            result = computeNextGeneration(grid, future, gridRows, gridColumns, generationNumber);
        }
    }
    static boolean computeNextGeneration(int[][] grid, int[][] future, int gridRows, int gridColumns, int generationNumber) {
        boolean ans = true;
        for (int i = 1; i < gridRows - 1; i++) {
            for (int j = 1; j < gridColumns - 1; j++) {
                int count = countAliveNeighbors(grid, i, j);
                if (grid[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        future[i][j] = 1;
                    } else {
                        future[i][j] = 0;
                    }
                } else {
                    if (count == 3) {
                        future[i][j] = 1;
                    }
                }
            }
        }
        System.out.println('\n' + "Generation " + generationNumber);
        printGrid(future, gridRows, gridColumns);
        if (Arrays.deepEquals(grid, future)) {
            ans = false;
        } else {
            if (isGridEmpty(future, gridRows, gridColumns)) {
                ans = false;
            } else {
                copyFutureToGrid(grid, future, gridRows, gridColumns);
                ans = true;
            }
        }
        return ans;
    }
    static void copyFutureToGrid(int[][] grid, int[][] future, int gridRows, int gridColumns) {
        for (int i = 1; i < gridRows - 1; i++) {
            for (int j = 1; j < gridColumns - 1; j++) {
                grid[i][j] = future[i][j];
            }
        }
    }
    static void initializeGridRandomly(int[][] grid, int gridRows, int gridColumns) {
        for (int[] row: grid) {
            Arrays.fill(row, 0);
        }
        Random rand = new Random();
        for (int i = 1; i < gridRows - 1; i++) {
            for (int j = 1; j < gridColumns - 1; j++) {
                grid[i][j] = rand.nextInt(2);
            }
        }
    }
    static boolean isGridEmpty(int[][] grid, int gridRows, int gridColumns) {
        boolean noAlive = true;
        for (int i = 1; i < gridRows - 1; i++) {
            for (int j = 1; j < gridColumns - 1; j++) {
                if (grid[i][j] != 0) {
                    noAlive = false; // Found a non-zero element, set the flag to false
                    break; // No need to continue checking, break out of the loop
                }
            }
            if (!noAlive) {
                break; // No need to continue checking, break out of the outer loop
            }
        }
        return noAlive;
    }
    static void printGrid(int[][] grid, int gridRows, int gridColumns) {
        for (int i = 1; i < gridRows - 1; i++) {
            for (int j = 1; j < gridColumns - 1; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int countAliveNeighbors(int[][] matrix, int x, int y) {
        int count = matrix[x - 1][y - 1] + matrix[x - 1][y] + matrix[x - 1][y + 1] +
            matrix[x][y - 1] + matrix[x][y + 1] + matrix[x + 1][y - 1] +
            matrix[x + 1][y] + matrix[x + 1][y + 1];

        return count;
    }
}