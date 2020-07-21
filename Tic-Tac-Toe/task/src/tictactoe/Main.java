package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String allSymbols = scanner.nextLine();
        String[] allSymbolsInArray = new String[9];
        for (int i = 0; i < 9; i++) {
            allSymbolsInArray[i] = allSymbols.substring(i, i+1);
        }
        System.out.println("---------");
        System.out.println("| " + allSymbolsInArray[0] + " "
                + allSymbolsInArray[1] + " "
                + allSymbolsInArray[2] + " |");
        System.out.println("| " + allSymbolsInArray[3] + " "
                + allSymbolsInArray[4] + " "
                + allSymbolsInArray[5] + " |");
        System.out.println("| " + allSymbolsInArray[6] + " "
                + allSymbolsInArray[7] + " "
                + allSymbolsInArray[8] + " |");
        System.out.println("---------");
    }
}
