import jdk.jshell.JShell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static int count = 0;
    public static void main(String[] args) {

//        Encryption encryption = new Encryption();
//        String result = encryption.encrypt(" if man was meant to stay on the ground god would have given us roots");
//        System.out.println(result);

//        StringProblems stringProblems = new StringProblems();
//        String result = stringProblems.convert("PAYPALISHIRING", 4);
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        int[] nums = {2,4,9,3};
        int[] result = arrayProblems.decrypt(nums, -2);
        for (int num : result) System.out.print(num + " ");

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
