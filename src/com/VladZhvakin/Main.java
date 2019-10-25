package com.VladZhvakin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] grid = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; // 0-empty 1-X 2-O
    private static boolean xWin = false;
    private static boolean oWin = false;

    public static void main(String[] args) {

        int numberOfCell = 0;
        int count = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printGrid();

        while (count < 9 && !oWin && !xWin) {

            while (true) {
                if(count%2==0)
                    System.out.println("X's makes move:");
                else System.out.println("O's makes move:");
                try {
                    numberOfCell = Integer.parseInt(bufferedReader.readLine());
                    if (numberOfCell < 1 || numberOfCell > 9) {
                        System.out.println("Enter digit from 1 to 9");
                        continue;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.out.println("Enter digit from 1 to 9");
                    continue;
                }
                if (isEmpty(coordinateFromNumberCell(numberOfCell))) {
                    if (count % 2 == 0)
                        writeCellX(coordinateFromNumberCell(numberOfCell));
                    else writeCellO(coordinateFromNumberCell(numberOfCell));
                    break;
                } else System.out.println("This cell not free! Enter number of free cell");

            }

            printGrid();
            oWin();
            xWin();
            count++;
        }

        if (xWin) System.out.println("X's win!");
        else if (oWin) System.out.println("O's win!");
        else System.out.println("Draw");


    }

    private static void xWin() {

        if (grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1 ||
                grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1 ||
                grid[2][0] == 1 && grid[2][1] == 1 && grid[2][2] == 1 ||
                grid[0][0] == 1 && grid[1][0] == 1 && grid[2][0] == 1 ||
                grid[0][1] == 1 && grid[1][1] == 1 && grid[2][1] == 1 ||
                grid[0][2] == 1 && grid[1][2] == 1 && grid[2][2] == 1 ||
                grid[0][0] == 1 && grid[1][1] == 1 && grid[2][2] == 1 ||
                grid[0][2] == 1 && grid[1][1] == 1 && grid[2][0] == 1)
            xWin = true;

    }

    private static void oWin() {
        if (grid[0][0] == 2 && grid[0][1] == 2 && grid[0][2] == 2 ||
                grid[1][0] == 2 && grid[1][1] == 2 && grid[1][2] == 2 ||
                grid[2][0] == 2 && grid[2][1] == 2 && grid[2][2] == 2 ||
                grid[0][0] == 2 && grid[1][0] == 2 && grid[2][0] == 2 ||
                grid[0][1] == 2 && grid[1][1] == 2 && grid[2][1] == 2 ||
                grid[0][2] == 2 && grid[1][2] == 2 && grid[2][2] == 2 ||
                grid[0][0] == 2 && grid[1][1] == 2 && grid[2][2] == 2 ||
                grid[0][2] == 2 && grid[1][1] == 2 && grid[2][0] == 2)
            oWin = true;
    }

    private static void writeCellX(int[] coordinate) {
        grid[coordinate[0]][coordinate[1]] = 1;
    }

    private static void writeCellO(int[] coordinate) {
        grid[coordinate[0]][coordinate[1]] = 2;
    }

    private static void printGrid() {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[x][y] == 0) {
                    System.out.print("[ ]");
                } else if (grid[x][y] == 1) {
                    System.out.print("[X]");
                } else
                    System.out.print("[O]");
            }
            System.out.println("\t");
        }
    }

    private static int[] coordinateFromNumberCell(int numberOfCell) {
        int x;
        int y;
        if (numberOfCell >= 7) {
            y = 0;
            x = numberOfCell - 7;
        } else if (numberOfCell >= 4) {
            y = 1;
            x = numberOfCell - 4;
        } else {
            y = 2;
            x = numberOfCell - 1;
        }
        return new int[]{x, y};
    }

    private static boolean isEmpty(int[] coordinate) {
        return grid[coordinate[0]][coordinate[1]] == 0;
    }


}
