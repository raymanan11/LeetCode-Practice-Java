import java.util.LinkedList;

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



}
