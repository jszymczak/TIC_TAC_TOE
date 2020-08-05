package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    boolean threeInARow = false;
    public static final String X_SIGN = "X";
    public static final String O_SIGN = "O";
    public static final String SPACE = "_";
    public static boolean fieldIsFilled = false;
    public static boolean valueIsApplied = false;
    public static int nextX = 0;
    public static int nextY = 0;
    public static final int[] validNumbers = {1, 2, 3};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String allSymbols = scanner.nextLine();
        String[] allSymbolsInArray = new String[9];
        String[][] myMatrix = new String[3][3];
        boolean threeOInARow = false;
        boolean threeXInARow = false;
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

        checkThreeInARow(myMatrix, threeOInARow, threeXInARow);

        checkStateOfMatrix(myMatrix, countX, countO);

//        if ((threeOInARow && threeXInARow) || Math.abs(countX - countO) >= 2) {
//            System.out.println("Impossible");
//        } else if (threeOInARow) {
//            System.out.println("O wins");
//        } else if (threeXInARow) {
//            System.out.println("X wins");
//        } else if (isEmptySpace) {
//            System.out.println("Game not finished");
//        } else {
//            System.out.println("Draw");
//        }

        addNextSign(myMatrix);

        printMatrix(myMatrix);

    }

    private static void checkThreeInARow(String[][] myMatrix, boolean threeOInARow, boolean threeXInARow) {
        for (int i = 0; i < 3; i++) {
            threeOInARow = isThreeSignInARow(myMatrix, threeOInARow, i, O_SIGN);
            threeXInARow = isThreeSignInARow(myMatrix, threeXInARow, i, X_SIGN);
        }
    }

    private static void checkStateOfMatrix(String[][] myMatrix, int countX, int countO) {
        boolean isEmptySpace = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (SPACE.equals(myMatrix[i][j])) {
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
    }

    private static void addNextSign(String[][] myMatrix) {
        boolean exceptionOccurred = false;
        do {
            try {
                validateCoordinates();
                if (fieldIsFilled) {
                    changeValueInField(myMatrix, nextX - 1, nextY - 1);
                }
                exceptionOccurred = false;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        } while (!fieldIsFilled || exceptionOccurred || !valueIsApplied);
    }

    public static void validateCoordinates() {
        Scanner coordinates = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        nextX = coordinates.nextInt();
        nextY = coordinates.nextInt();
        boolean xIsValid = IntStream.of(validNumbers).anyMatch(x -> x == nextX);
        boolean yIsValid = IntStream.of(validNumbers).anyMatch(y -> y == nextY);
        if (xIsValid && yIsValid) {
            if (nextY == 3) {
                nextY = 1;
            } else if (nextY == 1) {
                nextY = 3;
            }
            fieldIsFilled = true;
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            fieldIsFilled = false;
        }
    }

    private static boolean isThreeSignInARow(String[][] myMatrix, boolean threeInARow, int i, String sign) {
        if (myMatrix[i][0].equals(myMatrix[i][1]) && myMatrix[i][1].equals(myMatrix[i][2]) && sign.equals(myMatrix[i][0]) ||
                myMatrix[0][i].equals(myMatrix[1][i]) && myMatrix[1][i].equals(myMatrix[2][i]) && sign.equals(myMatrix[2][i]) ||
                myMatrix[0][0].equals(myMatrix[1][1]) && myMatrix[1][1].equals(myMatrix[2][2]) && sign.equals(myMatrix[0][0]) ||
                myMatrix[2][0].equals(myMatrix[1][1]) && myMatrix[1][1].equals(myMatrix[0][2]) && sign.equals(myMatrix[2][0])) {
            threeInARow = true;
        }
        return threeInARow;
    }

    private static void printMatrix(String[][] myMatrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0){
                    System.out.print("| ");
                }
                System.out.print(myMatrix[i][j] + SPACE);
                if (j == 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private static void changeValueInField(String[][] myMatrix, int valueX, int valueY) {
        if (!myMatrix[valueY][valueX].equals(SPACE)) {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            myMatrix[valueY][valueX] = X_SIGN;
            valueIsApplied = true;
        }
    }
}
