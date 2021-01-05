import java.util.Map;

public class DynamicProgramming {

    // regular fib function without dynamic programming

    public int fib (int n) {
        if (n <= 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

    // fib function with dynamic programming using memoization

    public long fib(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) return 1;
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }

}
