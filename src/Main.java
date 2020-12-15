import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        String s = "aA" +
//                "";
//        String result = stringProblems.reverseVowels(s);
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {2,4,9,3};
        int[] result = arrayProblems.decrypt(nums, -2);
        for (int num : result) {
            System.out.print(num + " ");
        }
//        Misc misc = new Misc();
//        int result = misc.divide(-2147483648, -1);
//        System.out.println(result);
    }
}
