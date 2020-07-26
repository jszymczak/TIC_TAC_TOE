package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String allSymbols = scanner.nextLine();
        String[] allSymbolsInArray = new String[9];
        String[][] myMatrix = new String[3][3];
        boolean threeOInARow = false;
        boolean threeXInARow = false;
        boolean isEmptySpace = false;
        final String O_SIGN = "O";
        final String X_SIGN = "X";
        int k = 0;
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < 9; i++) {
            allSymbolsInArray[i] = allSymbols.substring(i, i+1);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                myMatrix[i][j] = allSymbolsInArray[k];
                k++;
            }
        }

        printMatrix(myMatrix);

        for (int i = 0; i < 3; i++) {
            threeOInARow = isThreeSignInARow(myMatrix, threeOInARow, i, O_SIGN);
            threeXInARow = isThreeSignInARow(myMatrix, threeXInARow, i, X_SIGN);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ("_".equals(myMatrix[i][j])) {
                    isEmptySpace = true;
                }
                if (X_SIGN.equals(myMatrix[i][j])) {
                    countX++;
                }
                if (O_SIGN.equals(myMatrix[i][j])) {
                    countO++;
                }
            }
        }

        if ((threeOInARow && threeXInARow) || Math.abs(countX - countO) >= 2) {
            System.out.println("Impossible");
        } else if (threeOInARow) {
            System.out.println("O wins");
        } else if (threeXInARow) {
            System.out.println("X wins");
        } else if (isEmptySpace) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    private static boolean isThreeSignInARow(String[][] myMatrix, boolean threeOInARow, int i, String sign) {
        if (myMatrix[i][0].equals(myMatrix[i][1]) && myMatrix[i][1].equals(myMatrix[i][2]) && sign.equals(myMatrix[i][0]) ||
                myMatrix[0][i].equals(myMatrix[1][i]) && myMatrix[1][i].equals(myMatrix[2][i]) && sign.equals(myMatrix[2][i]) ||
                myMatrix[0][0].equals(myMatrix[1][1]) && myMatrix[1][1].equals(myMatrix[2][2]) && sign.equals(myMatrix[0][0]) ||
                myMatrix[2][0].equals(myMatrix[1][1]) && myMatrix[1][1].equals(myMatrix[0][2]) && sign.equals(myMatrix[2][0])) {
            threeOInARow = true;
        }
        return threeOInARow;
    }

    private static void printMatrix(String[][] myMatrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0){
                    System.out.print("| ");
                }
                System.out.print(myMatrix[i][j] + " ");
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
