package solution;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String[] tmp = input.split(",");
        int[] cashes = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            cashes[i] = Integer.valueOf(tmp[i]);
        }
        Solution s = new Solution();
        System.out.println(s.rob(cashes));
    }
}