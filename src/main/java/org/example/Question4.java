package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name: Sahil Samuel
 * Class Group: SD2A
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the starting row (0-9): ");
        int startRow = keyboard.nextInt();
        System.out.println("Enter the starting column (0-9): ");
        int startCol = keyboard.nextInt();

        int[][] grid = new int[10][10]; // 10×10 grid initialized to 0
        Stack<cell> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);


        stack.push(new cell(startRow, startCol)); // Push the starting cell onto the stack
        int fillNumber = 1; // Start filling with 1

        while (!stack.isEmpty()) {
            // Pop the cell from the stack
            cell current = stack.pop();
            int row = current.row;
            int col = current.column;

            // If the cell is unfilled, fill it and push its unfilled neighbors
            if (grid[row][col] == 0) {
                grid[row][col] = fillNumber++;

                // Check and push unfilled neighbors (north, east, south, west)
                if (row > 0 && grid[row - 1][col] == 0) { // North
                    stack.push(new cell(row - 1, col));
                }
                if (col < 9 && grid[row][col + 1] == 0) { // East
                    stack.push(new cell(row, col + 1));
                }
                if (row < 9 && grid[row + 1][col] == 0) { // South
                    stack.push(new cell(row + 1, col));
                }
                if (col > 0 && grid[row][col - 1] == 0) { // West
                    stack.push(new cell(row, col - 1));
                }
            }
        }

        // Print the filled grid
        System.out.println("Flood-filled grid:");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.printf("%3d", cell);
            }
            System.out.println();
        }
    }
}
