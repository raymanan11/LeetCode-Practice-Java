import java.util.LinkedList;
import java.util.List;

public class Misc {

    // Given a 32-bit signed integer, reverse digits of an integer.

    public int reverse(int x) {

        if (x == 0) return x;

        long a = x;
        String result = "";
        boolean negative = false;
        if (a < 0) {
            a = 0 - a;
            negative = true;
        }

        while (a != 0) {
            result = result.concat(String.valueOf(a % 10));
            a /= 10;
        }

        long numResult = Long.parseLong(result);
        if (negative) {
            numResult = 0 - numResult;
        }

        if(numResult < Integer.MIN_VALUE || numResult > Integer.MAX_VALUE) return 0;

        return (int) numResult;
    }

    // **
    // Given two integers dividend and divisor, divide two integers without
    // using multiplication, division, and mod operator.

    // Return the quotient after dividing dividend by divisor.

    // Input: dividend = 10, divisor = 3
    // Output: 3
    // Explanation: 10/3 = truncate(3.33333..) = 3.

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor == 1) return dividend;
        }
        if (dividend == Integer.MAX_VALUE) {
            if (divisor == -1) return 0 - Integer.MAX_VALUE;
            else if (divisor == 1) return Integer.MAX_VALUE;
        }
        int count = 0;
        boolean negative = true;
        if (dividend >= 0 && divisor >= 0 || dividend < 0 && divisor < 0) negative = false;

        if (dividend < 0) dividend = 0 - dividend;
        if (divisor < 0) divisor = 0 - divisor;

        int setDivisor = divisor;

        while (divisor <= dividend) {
            count++;
            divisor += setDivisor;
        }
        if (negative) return count * -1;
        else return count;
    }

    public static int updateTimes(List<Integer> signalOne, List<Integer> signalTwo) {
        int minimumLength = (signalOne.size() < signalTwo.size()) ? signalOne.size() : signalTwo.size();
        int max = 0;
        int updateTimes = 0;
        for (int i = 0; i < minimumLength; i++) {
            if (signalOne.get(i).equals(signalTwo.get(i))) {
                if (signalOne.get(i) > max) {
                    max = Math.max(max, signalOne.get(i));
                    updateTimes++;
                }
            }
        }
        return updateTimes;
    }

}
