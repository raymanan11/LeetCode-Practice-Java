import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        String s = "aA" +
//                "";
//        String result = stringProblems.reverseVowels(s);
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {1,2,2,6,6,6,6,7,10};
        int result = arrayProblems.findSpecialInteger(nums);
        System.out.println(result);

//        Misc misc = new Misc();
//        int result = misc.divide(-2147483648, -1);
//        System.out.println(result);
    }
}
