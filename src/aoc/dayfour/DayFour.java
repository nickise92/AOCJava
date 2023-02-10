package aoc.dayfour;

import aoc.inputfile.InputReader;
import java.util.Scanner;

public class DayFour {

    public static void main(String[] args) {
        InputReader reader = new InputReader("inputday4.txt");
        System.out.printf("Part one result: %d%n", partOne(reader.getFileContent()));
        System.out.printf("Part two result: %d%n", partTwo(reader.getFileContent()));

    }

    /* --- Other methods --- */
    /**
     * Return true if range A is inside range B. For instance range 2-4 is inside range 1-5.
     * @param rangeA a String that contains the range written in the format 'min_value'-'max_value'
     *               (I.E. 2-5).
     * @param rangeB a String that contains the range written in the format 'min_value'-'max_value'
     *               (I.E. 31-675).
     * @return True, if range A is in range B, False otherwise.
     */
    private static boolean fullyContained(String rangeA, String rangeB) {
        int minA = Integer.parseInt(rangeA.split("-")[0]);
        int maxA = Integer.parseInt(rangeA.split("-")[1]);
        int minB = Integer.parseInt(rangeB.split("-")[0]);
        int maxB = Integer.parseInt(rangeB.split("-")[1]);

        return minB <= minA && maxA <= maxB;
    }

    private static boolean overlaps(String rangeA, String rangeB) {
        int minA = Integer.parseInt(rangeA.split("-")[0]);
        int maxA = Integer.parseInt(rangeA.split("-")[1]);
        int minB = Integer.parseInt(rangeB.split("-")[0]);
        int maxB = Integer.parseInt(rangeB.split("-")[1]);

        return minB <= minA && minA <= maxB || minB <=maxA && maxA <= maxB;
    }


    /* --- Part One --- */
    public static int partOne(String inputStr) {
        Scanner scanner = new Scanner(inputStr);
        int counter = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] ranges = line.split(",");



           if (fullyContained(ranges[0], ranges[1])) {           // Check if LeftRange is contained in RightRange
               counter = counter + 1;
           } else if (fullyContained(ranges[1], ranges[0])) {    // Check if RightRange is contained in LeftRange
                counter = counter + 1;
            }
        }

        scanner.close();
        return counter;
    }

    /* --- Part One --- */
    public static int partTwo(String inputStr) {
        Scanner scanner = new Scanner(inputStr);
        int counter = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] ranges = line.split(",");

            if (overlaps(ranges[0], ranges[1])) {
                counter = counter + 1;
            } else if (overlaps(ranges[1], ranges[0])) {
                counter = counter + 1;
            }
        }

        return counter;
    }
}
