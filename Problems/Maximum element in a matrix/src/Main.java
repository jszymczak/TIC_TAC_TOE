import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowNumber = scanner.nextInt();
        int columnNumber = scanner.nextInt();
        int maxNumber;
        int rowINumber = 0;
        int columnJNumber = 0;
        int[][] myMatrix = new int[rowNumber][columnNumber];
        boolean maxNumberIsFound = false;


        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                myMatrix[i][j] = scanner.nextInt();
            }
        }

        maxNumber = getMaxNumber(rowNumber, myMatrix);

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                if (myMatrix[i][j] == maxNumber) {
                    maxNumber = myMatrix[i][j];
                    rowINumber = i;
                    columnJNumber = j;
                    maxNumberIsFound = true;
                    break;
                }
            }
            if (maxNumberIsFound) {
                break;
            }
        }

        System.out.println(rowINumber + " " + columnJNumber);
    }

    private static int getMaxNumber(int rowNumber, int[][] myMatrix) {
        int[] max = new int[rowNumber];
        int maxNumber;
        for (int i = 0; i < rowNumber; i++) {
            max[i] = Arrays.stream(myMatrix[i]).max().getAsInt();
        }

        maxNumber = Arrays.stream(max).max().getAsInt();
        return maxNumber;
    }
}
