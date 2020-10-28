
import java.util.*;

public class ArrayProblems {


    // {-2,-1,0,1,2,3}
    public List<List<Integer>> threeSum (int[] nums) {

        if (nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);

        Set<List<Integer>> uniqueresults = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) uniqueresults.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else j++;
            }
        }

        return new ArrayList<>(uniqueresults);

    }

}
