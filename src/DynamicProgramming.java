public class DynamicProgramming {

    // regular fib function without dynamic programming

    public int fib (int n) {
        if (n <= 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

}
