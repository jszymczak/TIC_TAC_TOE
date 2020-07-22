import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxI = scanner.nextInt();
        int maxJ = scanner.nextInt();
        int[][] baseArray = new int[maxI][maxJ];
        int[][] changedArray = new int[maxI][maxJ];

        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                baseArray[i][j] = scanner.nextInt();
            }
        }
        int swappedI = scanner.nextInt();
        int swappedJ = scanner.nextInt();

        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                if (j == swappedI) {
                    changedArray[i][j] = baseArray[i][swappedJ];
                } else if (j == swappedJ) {
                    changedArray[i][j] = baseArray[i][swappedI];
                } else {
                    changedArray[i][j] = baseArray[i][j];
                }
                System.out.print(changedArray[i][j] + " ");
            }
            System.out.println("");
        }
    }
}