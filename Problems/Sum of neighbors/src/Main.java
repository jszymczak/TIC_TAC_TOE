import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String END = "end";
        String temp = "";
        List<String> testList = new ArrayList<>();
        do {
             temp = scanner.nextLine();
             testList.add(temp);
        } while (END.equals(temp));

        System.out.println("LOOP WHILE ESCAPED");

        for (int i = 0; i < testList.size()-1; i++) {
            System.out.println(testList.get(i));
        }

        System.out.println("LOOP FOR ESCAPED");
//        int[][] neighboursMatrix = new int[][];


    }
}