package solution;

import java.lang.*;
import java.util.*;

class Solution {
    public String decodeString(String s) {
        int i = 0;
        Stack<String> stack = new Stack<>();
        String tmpS = "";
        String tmpI = "";

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                System.out.println(stack.toString());
                tmpS += c;
            } else if (Character.isDigit(c)) {
                System.out.println(stack.toString());
                if (tmpS.length() > 0) {
                    if (!stack.empty() && !stack.peek().equals("[")) {
                        stack.push(stack.pop() + tmpS);
                    } else {
                        stack.push(tmpS);
                    }

                    tmpS = "";
                }
                tmpI += c;
            } else if (c == '[') {
                System.out.println(stack.toString());
                if (tmpI.length() > 0) {
                    stack.push(tmpI);
                    tmpI = "";
                } else {
                    throw new RuntimeException("No Digits before [");
                }
                stack.push(Character.toString(c));
            } else if (c == ']') {
                System.out.println(stack.toString());
                if (tmpS.length() > 0) {
                    if (!stack.empty() && !stack.peek().equals("[")) {
                        stack.push(stack.pop() + tmpS);
                    } else {
                        stack.push(tmpS);
                    }
                    tmpS = "";
                }

                String str = stack.pop();
                if (stack.peek().equals("[")) {
                    stack.pop();
                }
                String integer = stack.pop();
                if (stack.empty() || stack.peek().equals("[")) {
                    stack.push(repeatString(str, Integer.parseInt(integer)));
                } else {
                    stack.push(stack.pop() + repeatString(str, Integer.parseInt(integer)));
                }
            }
            i++;
        }

        if (stack.empty()) {
            return s;
        } else {
            System.out.println(stack.toString());
            return stack.pop() + tmpS;
        }
    }

    private String repeatString(String input, int times) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i< times; i++) {
            b.append(input);
        }
        return b.toString();
    }
}