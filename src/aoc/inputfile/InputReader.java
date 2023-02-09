package aoc.inputfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

    private String fileContent;

    /**
     * Constructor
     * @param inputPath - needed to open the file
     */
    public InputReader(String inputPath) {
        fileContent = readInput(inputPath);
    }

    public String getFileContent() {
        return fileContent;
    }

    /**
     * @param inputPath - Path of the file to convert into a String
     * @return the content of the file as a String.
     */
    private String readInput(String inputPath) {

        StringBuilder inputStr = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(inputPath))) {
            String str;
            /**
             * Keep cycling until end of file
             */
            while ((str = buffer.readLine()) != null) {
                inputStr.append(str).append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return inputStr.toString();
    }

}
