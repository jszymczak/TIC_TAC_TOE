import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arrayOfInt = new int[size];
        boolean ascendingSequence = true;
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfInt[i] = scanner.nextInt();
        }
        for (int i = 0; i < arrayOfInt.length - 1; i++) {
            if (arrayOfInt[i] >= arrayOfInt[i + 1]) {
                ascendingSequence = false;
                break;
            }
        }
        System.out.println(ascendingSequence);
    }
}