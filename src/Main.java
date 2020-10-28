import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayProblems arr = new ArrayProblems();

        int[] nums = {3,0,-2,-1,1,2};
        List<List<Integer>> result = arr.threeSum(nums);

        System.out.println(result);
    }

}
