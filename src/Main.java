import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        String s = "aA" +
//                "";
//        String result = stringProblems.reverseVowels(s);
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {1,2,3,4};
        int[][] nums2 = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] result = arrayProblems.sumEvenAfterQueries(nums, nums2);

//        Misc misc = new Misc();
//        int result = misc.divide(-2147483648, -1);
//        System.out.println(result);
    }
}
