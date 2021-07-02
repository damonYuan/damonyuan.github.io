package solution;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Brackets(3);
    }

    public static void Brackets(int n) {
        for (int i = 1; i <= n; i++) {
            Brackets("", 0, 0, i);
        }
    }

    private static void Brackets(String output, int open, int close, int pairs) {
        if((open==pairs)&&(close==pairs)) {
            System.out.println(output);
        } else {
            if(open<pairs)
                Brackets(output + "(", open+1, close, pairs);
            if(close<open)
                Brackets(output + ")", open, close+1, pairs);
        }
    }
}