import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//
//        String[] strs = {"c","acc","ccc"};
//        String result = stringProblems.longestCommonPrefix(strs);
//
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();

        int[] nums = {};
        int[] result = arrayProblems.searchRange(nums, 0);

        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
