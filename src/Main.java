import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringProblems stringProblems = new StringProblems();
        String[] banned = {"bob", "hit"};
        String result = stringProblems.mostCommonWord("Bob. hIt, baLl", banned);
        System.out.println(result);

//        ArrayProblems arrayProblems = new ArrayProblems();
//        int[] nums = {2,2,3,4};
//        int result = arrayProblems.findLucky(nums);
//        System.out.println(result);
//        Misc misc = new Misc();
//        int result = misc.divide(-2147483648, -1);
//        System.out.println(result);

    }
}
