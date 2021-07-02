package solution;

import java.lang.Character;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        if (isBalanced(expression)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(')');
            } else if (expression.charAt(i) == '{') {
                stack.push('}');
            } else if (expression.charAt(i) == '[') {
                stack.push(']');
            } else {
                if (stack.empty() || expression.charAt(i) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}