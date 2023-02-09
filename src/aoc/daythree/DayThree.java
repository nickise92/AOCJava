package aoc.daythree;
import aoc.inputfile.InputReader;
import java.util.Scanner;

public class DayThree {

    public static final String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        InputReader reader = new InputReader("inputday3.txt");
        System.out.println(String.format("Part one result: %d", partOne(reader.getFileContent())));
        System.out.println(String.format("Part two result: %d", partTwo(reader.getFileContent())));
    }

    /* --- Others Methods --- */
    private static boolean isInside (char c, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /* --- Part One --- */
    private static int partOne(String inputStr) {
        Scanner scanner = new Scanner(inputStr);
        int priority = 0;

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int mid = line.length() / 2;
            boolean flag = true;

            String[] parts = {line.substring(0, mid), line.substring(mid)};
            for (int i = 0; i < mid && flag; i++) {

                if (isInside(parts[0].charAt(i), parts[1])) {
                    priority += priorities.indexOf(parts[0].charAt(i)) + 1;
                    flag = false;
                }
            }
        }

        scanner.close();
        return priority;
    }

    /* --- Part Two --- */
    private static int partTwo(String inputStr) {
        int badges = 0;

        Scanner scanner = new Scanner(inputStr);

        while (scanner.hasNextLine()) {
            boolean flag = true;
            /* group of three elves */
            String firstRucksack = scanner.nextLine();
            String secondRucksack = scanner.nextLine();
            String thirdRucksack = scanner.nextLine();

            // check badge in the three rucksacks
            for (int i = 0; i < firstRucksack.length() && flag; i++) {
                if (isInside(firstRucksack.charAt(i), secondRucksack)
                        && isInside(firstRucksack.charAt(i), thirdRucksack)) {
                    badges += priorities.indexOf(firstRucksack.charAt(i)) + 1;
                    flag = false;
                }
            }
        }

        scanner.close();
        return badges;
    }
}
