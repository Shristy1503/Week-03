package runtimeanalysis.recursivevsiterativefibonaccicomputation;

public class RecursiveVsIterativeFibonacci {
    public static void main(String[] args) {
        int[] values = {10, 30};

        for (int n : values) {
            System.out.println("Fibonacci(" + n + ") Computation:");

            //recursive time
            long startRecursive = System.nanoTime();
            long recursiveResult = recursiveFibonacci(n);
            double recursiveTime = (System.nanoTime() - startRecursive) / 1000000.0;
            System.out.printf("Recursive Result: %d | Time: %.3f ms%n", recursiveResult, recursiveTime);

            //iterative time
            long startIterative = System.nanoTime();
            long iterativeResult = iterativeFibonacci(n);
            double iterativeTime = (System.nanoTime() - startIterative) / 1000000.0;
            System.out.printf("Iterative Result: %d | Time: %.3f ms%n", iterativeResult, iterativeTime);

            System.out.println();
        }
    }
    //recursive method
    public static long recursiveFibonacci(int n) {
        if (n <= 1) return n;
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }
    //iterative method
    public static long iterativeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
