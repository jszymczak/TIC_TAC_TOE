package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static final String X_SIGN = "X";
    public static final String O_SIGN = "O";
    public static final String SPACE = " ";
    public static int nextX = 0;
    public static int nextY = 0;
    public static int status = 0;
    public static final int[] validNumbers = {1, 2, 3};

    public static void main(String[] args) {
        String allSymbols = "         ";
        String[] allSymbolsInArray = new String[9];
        String[][] myMatrix = new String[3][3];
        boolean threeOInARow = false;
        boolean threeXInARow = false;
        boolean isEmptySpace = false;
        boolean threeInARow = false;
        boolean existsWinnerO = false;
        boolean existsWinnerX = false;
        int chooseXorO = 1;
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

        do {
            switch (chooseXorO) {
                case 1:
                    addNextSign(myMatrix, X_SIGN);
                    break;
                case -1:
                    addNextSign(myMatrix, O_SIGN);
                    break;
            }
            existsWinnerO = checkThreeOInARow(myMatrix, threeOInARow);
            existsWinnerX = checkThreeXInARow(myMatrix, threeXInARow);

            printMatrix(myMatrix);

            boolean gameNotFinished = checkStateOfMatrix(myMatrix);
            if (existsWinnerO && existsWinnerX) {
                System.out.println("Impossible");
            } else if (existsWinnerO) {
                System.out.println("O wins");
                status = 5;
            } else if (existsWinnerX) {
                System.out.println("X wins");
                status = 5;
            } else if (gameNotFinished) {
//                System.out.println("Game not finished");
                status = 10;
            } else {
                System.out.println("Draw");
                status = 5;
            }
            chooseXorO *= -1;
        } while (status != 5);
    }

    private static boolean checkThreeXInARow(String[][] myMatrix, boolean threeXInARow) {
        for (int i = 0; i < 3; i++) {
            threeXInARow = isThreeSignInARow(myMatrix, threeXInARow, i, X_SIGN);
        }
        return threeXInARow;
    }

    private static boolean checkThreeOInARow(String[][] myMatrix, boolean threeOInARow) {
        for (int i = 0; i < 3; i++) {
            threeOInARow = isThreeSignInARow(myMatrix, threeOInARow, i, O_SIGN);
        }
        return threeOInARow;
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

    private static boolean checkStateOfMatrix(String[][] myMatrix) {
        int countX = 0;
        int countO = 0;
        boolean isCorrectNumberOfSigns;
        boolean processTheGame;
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
        isCorrectNumberOfSigns = Math.abs(countX - countO) <= 2;
        processTheGame = isCorrectNumberOfSigns && isEmptySpace;
        return processTheGame;
    }

    private static void addNextSign(String[][] myMatrix, String sign) {
        boolean exceptionOccurred = false;
        boolean valueHasChanged = false;
        boolean fieldIsCorrectlyFilled = false;
        do {
            try {
                fieldIsCorrectlyFilled = validateCoordinates();
                if (fieldIsCorrectlyFilled) {
                    valueHasChanged = changeValueInField(myMatrix, nextX - 1, nextY - 1, sign);
                }
                exceptionOccurred = false;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        } while (exceptionOccurred || !valueHasChanged);
    }

    public static boolean validateCoordinates() {
        boolean fieldIsFilled = false;
        Scanner coordinates = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        nextX = coordinates.nextInt();
        nextY = coordinates.nextInt();
        boolean xIsValid = IntStream.of(validNumbers).anyMatch(x -> x == nextX);
        boolean yIsValid = IntStream.of(validNumbers).anyMatch(y -> y == nextY);
        if (xIsValid && yIsValid) {
            nextY = nextY == 3 ? 1 : nextY == 1 ? 3 : nextY;
            fieldIsFilled = true;
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
        }
        return fieldIsFilled;
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

    private static boolean changeValueInField(String[][] myMatrix, int valueX, int valueY, String signValue) {
        boolean valueIsApplied = false;
        if (!myMatrix[valueY][valueX].equals(SPACE)) {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            myMatrix[valueY][valueX] = signValue;
            valueIsApplied = true;
        }
        return valueIsApplied;
    }
}
