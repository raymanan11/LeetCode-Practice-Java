import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Encryption encryption = new Encryption();
//        String result = encryption.encrypt(" if man was meant to stay on the ground god would have given us roots");
//        System.out.println(result);

//        StringProblems stringProblems = new StringProblems();
//        boolean result = stringProblems.isLongPressedName("alex", "aaleexx");
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int result = arrayProblems.removeDuplicates(nums);
        System.out.println(result);
//
//        for (int n : nums) System.out.print(n + " ");
//
//        Misc misc = new Misc();
//        int result = misc.divide(-2147483648, -1);
//        System.out.println(result);

//        DynamicProgramming dynamicProgramming = new DynamicProgramming();
//        int fib1 = dynamicProgramming.gridTraveler(2,3);
//        long gt = dynamicProgramming.gridTraveler(50,50, new HashMap<>());
//
//        System.out.println(gt);

    }
}
