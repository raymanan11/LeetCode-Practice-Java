import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Encryption encryption = new Encryption();
//        String result = encryption.encrypt(" if man was meant to stay on the ground god would have given us roots");
//        System.out.println(result);

//        StringProblems stringProblems = new StringProblems();
//        String result = stringProblems.convert("PAYPALISHIRING", 4);
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();
        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(5);
        a1.add(7);
        a1.add(7);
        List<Integer> b1 = new ArrayList<>();
        b1.add(0);
        b1.add(1);
        b1.add(2);
        b1.add(3);
        List<Integer> result = arrayProblems.mergeArrays(a1,b1);
        System.out.println(result);

        System.out.println(7 & (1 << 4));
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
