package Robot;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class CoordinateRobot {


    public static void main(String[] args) throws IOException {


        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        Scanner scanner = new Scanner(inputFile);
        FileWriter writer = new FileWriter(outputFile);
        int n = scanner.nextInt();

        String result;
        int x = 0, y = 0;
        if (n > 0) {
            for (int r = 0; ; r++) {
                int from = r * (r - 1) * 4 + 1;
                int to = r * (r + 1) * 4;

                if (n <= to) {
                    int q = (n - from) / (r * 2);
                    int numberQ = (n - from) % (r * 2) + 1;

                    switch (q) {
                        case 0 -> {
                            x = -r;
                            y = r - numberQ;
                        }
                        case 1 -> {
                            x = numberQ - r;
                            y = -r;
                        }
                        case 2 -> {
                            x = r;
                            y = numberQ - r;
                        }
                        case 3 -> {
                            x = r - numberQ;
                            y = r;
                        }
                    }
                    break;
                }
            }

        }
        result = x + " " + y;
        Files.write(Paths.get("output.txt"), result.getBytes());
    }
}