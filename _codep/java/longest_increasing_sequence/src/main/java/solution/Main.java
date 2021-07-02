package solution;

public class Main {
    public static void main(String[] args) {
        int[] input = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11,4,5,6, 7, 15, 8, 9};
        int result = DpSolution.lis(input, input.length);
        System.out.println(result);
    }
}