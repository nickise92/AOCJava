package aoc.dayone;
import aoc.inputfile.InputReader;

import java.util.Scanner;

public class DayOne {

    public static void main(String[] args) {
        InputReader reader = new InputReader("inputday1.txt");
        String inputStr = reader.getFileContent();
        System.out.println(String.format("Part one result: %d", partOne(inputStr)));
        System.out.println(String.format("Part two result: %d", partTwo(inputStr)));
    }

    /* Part one */
    public static int partOne(String inputStr) {

        int maxCalories = 0;
        int tmp = 0;
        Scanner scanner = new Scanner(inputStr);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("")) {
                if (maxCalories < tmp) {
                    // Imposto come massimo il numero piu' alto di calorie
                    // e azzero tmp per calcolare le calorie dell'elfo
                    // successivo.
                    maxCalories = tmp;
                }
                tmp = 0;
            } else {
                tmp = tmp + Integer.valueOf(line);
            }
        }

        scanner.close();
        return maxCalories;
    }

    /* PART TWO */
    public static int partTwo(String inputStr) {
        int firstElf = partOne(inputStr);
        int secondElf = secondElf(inputStr, firstElf);
        int thirdElf = thirdElf(inputStr, firstElf, secondElf);

        return firstElf + secondElf + thirdElf;
    }

    public static int secondElf(String inputStr, int firstElf) {
        int secondElf = 0;
        int tmp = 0;
        Scanner scanner = new Scanner(inputStr);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("")) {
                if (secondElf < tmp && tmp != firstElf) {
                    secondElf = tmp;
                }
                tmp = 0;
            } else {
                tmp = tmp + Integer.valueOf(line);
            }
        }

        scanner.close();
        return secondElf;
    }

    private static int thirdElf(String inputStr, int firstElf, int secondElf) {
        int thirdElf = 0;
        int tmp = 0;
        Scanner scanner = new Scanner(inputStr);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("")) {
                if (thirdElf < tmp && tmp != firstElf && tmp != secondElf) {
                    thirdElf = tmp;
                }
                tmp = 0;
            } else {
                tmp = tmp + Integer.valueOf(line);
            }
        }

        scanner.close();
        return thirdElf;
    }


}
