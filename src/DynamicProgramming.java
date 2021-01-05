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

    // Grid Traveler w/o DP

    public int gridTraveler(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

}
