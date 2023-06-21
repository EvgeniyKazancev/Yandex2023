
import Robot.CoordinateRobot;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


public class CoordinateRobotTest {


    class RobotTest {
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";

        @Test
        public void test1() throws Exception {
            String input = "0";
            String expected = "0 0";
            assertEquals(expected, getActual(input));
        }

        @Test
        public void test2() throws Exception {
            String input = "1";
            String expected = "-1 0";
            assertEquals(expected, getActual(input));
        }

        @Test
        public void test3() throws Exception {
            String input = "2";
            String expected = "-1 -1";
            assertEquals(expected, getActual(input));
        }

        @Test
        public void test4() throws Exception {
            String input = "14";
            String expected = "0 -2";
            assertEquals(expected, getActual(input));
        }

        private String getActual(String input) throws Exception {
            Files.write(Paths.get(inputFilename), input.getBytes());
            CoordinateRobot.main(new String[]{});
            return Files.readAllLines(Paths.get(outputFilename)).get(0);
        }
    }
}
