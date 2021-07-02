package solution;

import java.lang.Character;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.next();
        Solution s = new Solution();
        System.out.println(s.decodeString(expression));
    }
}