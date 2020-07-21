import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 3;
        int[] firstBox = new int[size];
        int[] secondBox = new int[size];

        for (int i = 0; i < firstBox.length; i++) {
            firstBox[i] = scanner.nextInt();
        }
        for (int i = 0; i < secondBox.length; i++) {
            secondBox[i] = scanner.nextInt();
        }

        Arrays.sort(firstBox);
        Arrays.sort(secondBox);

        for (int i = 0; i < 3; i++) {
            if (isIncomparable(firstBox, secondBox)) {
                System.out.println("Incomparable");
                break;
            } else if (isEqual(firstBox, secondBox)) {
                System.out.println("Box 1 = Box 2");
                break;
            } else if (firstBox[i] < secondBox[i]) {
                System.out.println("Box 1 < Box 2");
                break;
            } else if (firstBox[i] > secondBox[i]) {
                System.out.println("Box 1 > Box 2");
                break;
            }
        }
    }

    private static boolean isEqual(int[] firstBox, int[] secondBox) {
        boolean isEqual = false;
        if (Arrays.equals(firstBox, secondBox)) {
            isEqual = true;
        }
        return isEqual;
    }

    private static boolean isIncomparable(int[] firstBox, int[] secondBox) {
        boolean isIncomparable = false;
        if (firstBox[0] < secondBox[0] && firstBox[2] > secondBox[2] ||
                firstBox[0] > secondBox[0] && firstBox[2] < secondBox[2]) {
            isIncomparable = true;
        }
        return isIncomparable;
    }
}