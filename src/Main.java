import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        String result = stringProblems.longestPalindrome("babad");
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {2,2,1,1,1,2,2};
        int result = arrayProblems.majorityElement(nums);
        System.out.println(result);
//
//        for (int n : nums) System.out.print(n + " ");

//        Misc misc = new Misc();
//        int result = misc.divide(-2147483648, -1);
//        System.out.println(result);

//        String s = "hell";
//        System.out.println(s.substring(2, 4));

    }
}
