import java.util.List;

public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        char[] c = {'h','e','l','l','o'};
//        stringProblems.reverseString(c);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int result = arrayProblems.removeDuplicates(nums);
        System.out.println(result);
    }
}
