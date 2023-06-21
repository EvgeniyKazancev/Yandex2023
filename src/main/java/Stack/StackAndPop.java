package Stack;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class StackAndPop {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        StackWithMax stack = new StackWithMax();

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfLines; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "push" -> stack.push(Integer.parseInt(command[1]));
                case "pop" -> stack.pop();
                case "max" -> System.out.println(stack.max());
            }
        }
    }
    public static class StackWithMax extends Stack<Integer> {

           Stack<Integer> s2;

        public StackWithMax() throws IOException {
            s2 = new Stack<>();
        }


        public  void push(int value) {
            if (value > max()) {
                s2.push(value);
            }
            super.push(value);
        }


        public Integer pop() {
            int value = super.pop();
            if (value == max()) {
                s2.pop();
            }
            return value;
        }


        public int max() {
            if (s2.isEmpty()) {
                return Integer.MIN_VALUE;
            } else {
                return s2.peek();
            }
        }
    }
}
