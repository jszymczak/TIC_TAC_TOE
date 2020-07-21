import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int sizeOfArray = scanner.nextInt();
        int[] myArrayOfInts = new int[sizeOfArray];

        for (int i = 0; i < myArrayOfInts.length; i++) {
            myArrayOfInts[i] = scanner.nextInt();
        }

        for (int number:
             myArrayOfInts) {
            sum += number;
        }

        System.out.println(sum);
    }
}