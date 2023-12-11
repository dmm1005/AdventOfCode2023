package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Trebuchet {

    public static void main(String[] args) throws IOException {
            int result = 0;
            List<String> lines = getAllLines("./src/day1/input.txt");
            for (String line : lines) {
                System.out.printf("%s\n", line);
                int firstDigit = 0;
                int lastDigit = 0;

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c)) {
                        firstDigit = Character.getNumericValue(c);
                        break;
                    }
                }

                for (int i = line.length() - 1; i >= 0; i--) {
                    char c = line.charAt(i);
                    if (Character.isDigit(c)) {
                        lastDigit = Character.getNumericValue(c);
                        break;
                    }
                }
                int digits = Integer.parseInt(String.valueOf(firstDigit) + String.valueOf(lastDigit));
                System.out.printf("Digits detected: %d, %d\n", firstDigit, lastDigit);
                result += digits;

            }
            System.out.printf("Final result: %d\n", result);
        }



    private static List<String> getAllLines(String path) {
        {
            try {
                return Files.readAllLines(Paths.get(path));
            } catch (IOException e) {
                System.out.println("Could not open the input file.");
                return new ArrayList<String>();
            }
        }
    }

}
