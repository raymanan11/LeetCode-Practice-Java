
import java.util.*;

public class ArrayProblems {

    //    Given an integer array nums, find the contiguous subarray (containing at least one number)
    //    which has the largest sum and return its sum.

    //    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //    Output: 6
    //    Explanation: [4,-1,2,1] has the largest sum = 6.

    //    Input: nums = [-2147483647]
    //    Output: -2147483647

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];

        int largest = nums[0];
        int max_end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max_end = Math.max(nums[i], nums[i] + max_end);
            largest = Math.max(largest, max_end);
        }
        return largest;
    }

    // Say you have an array for which the ith element is the price of a given stock on day i.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
    // design an algorithm to find the maximum profit.

    // Input: [7,1,5,3,6,4]
    // Output: 5

    public int maxProfit(int[] nums) {
        int maxProfit = 0;
        int smallestStock = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int transactionProfit = nums[i] - smallestStock;
            // kepp track of the smallest stock
            if (nums[i] < smallestStock) smallestStock = nums[i];
            // keep track of largest profit
            else if (nums[i] - smallestStock > maxProfit) maxProfit = transactionProfit;
        }
        return maxProfit;
    }

    // Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.

    // Input: nums = [-1,0,1,2,-1,-4]
    // Output: [[-1,-1,2],[-1,0,1]]

    public List<List<Integer>> threeSum (int[] nums) {

        // if nums array is less than 3, then return empty list []
        if (nums.length < 3) return new ArrayList<>();

        // sort the nums array
        Arrays.sort(nums);

        // use a set in order to achieve unique results
        Set<List<Integer>> uniqueresults = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // index next to i
            int j = i + 1;
            // last index
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // if the sum == 0, add it to the set
                if (sum == 0) uniqueresults.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                // else if sum > 0 that means you have to decrement k to get sum lower to
                // potentially reach 0
                else if (sum > 0) k--;
                // else if sum < 0 that means you have to mve j to get sum higher to potentially
                // reach zero
                else j++;
            }
        }

        return new ArrayList<>(uniqueresults);

    }

    // Get the four largest numbers in the array and return their sum
    // If array has less than four numbers, return their sums

    // Input: {0, -1, 4, 2, 7,-3, 10}
    // Output: 23

    public int fourLargest(int[] nums) {
        int result = 0;
        if (nums.length < 4) {
            for (int i = 0; i < nums.length; i++) {
                result = result + nums[i];
            }
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < 4; i++) {
            result = result + nums[nums.length - 1 - i];
        }
        return result;
    }

    // If the sequence is Arithmetic, return "Arithmetic", if the sequence is Geometric, return "Geometric"
    // If the sequence follows neither pattern, return -1

    // Input: {5,10,15}      {2,6,18,54}          {2,4,16,24}
    // Output: Arithmetic    Output: Geometric    Output: -1

    public Object arrayChallenge(int[] nums) {
        Set<Integer> arithmetic = new HashSet<>();
        Set<Integer> geometric = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            arithmetic.add(nums[nums.length - 1 - i] - nums[nums.length - 2 - i]);
            geometric.add(nums[nums.length - 1 - i] / nums[nums.length - 2 - i]);
        }
        if (arithmetic.size() == 1) return "Arithmetic";
        else if (geometric.size() == 1) return "Geometric";
        else return -1;
    }

    // Given an array of integers nums sorted in ascending order,
    // find the starting and ending position of a given target value.
    // If target is not found in the array, return [-1, -1].

    // Input: nums = [5,7,7,8,8,10], target = 8      Input: nums = [5,7,7,8,8,10], target = 6
    // Output: [3,4]                                 Output: [-1,-1]

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[nums.length - 1 - i] == target) {
                result[1] = nums.length - 1 - i;
                break;
            }
        }

        return result;
    }

    // Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    // Input:
    // nums1 = [1,2,3,0,0,0], m = 3
    // nums2 = [2,5,6],       n = 3

    // Output: [1,2,2,3,5,6]

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        Arrays.sort(nums1);

    }

    // Given an array nums and a value val,
    // remove all instances of that value in-place and return the new length.

    // Input: nums = [3,2,2,3], val = 3    Input: nums = [0,1,2,2,3,0,4,2], val = 2
    // Output: 2, nums = [2,2]             Output: 5, nums = [0,1,4,0,3]

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // Given the array of integers nums, you will choose two different indices i and j of that array.
    // Return the maximum value of (nums[i]-1)*(nums[j]-1).

    // Input: nums = [3,4,5,2]
    // Output: 12
    // Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is,
    // (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < 2; i++) {
            result *= nums[nums.length - 1 - i] - 1;
        }

        return result;
    }

    // Given an unsorted integer array nums, find the smallest missing positive integer.

    // Input: nums = [1,2,0]     Input: nums = [3,4,-1,1]
    // Output: 3                 Output: 2

    public int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);

        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        // make sure the ArrayList is ordered as well as no duplicate numbers
        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNumbers.contains(nums[i])) uniqueNumbers.add(nums[i]);
        }

        int currentPositiveNum = 1;
        for (int i = 0; i < uniqueNumbers.size(); i++) {
            // if numbers is < or = to 0 ignore
            if (uniqueNumbers.get(i) <= 0) continue;
            if (uniqueNumbers.get(i) == currentPositiveNum) {
                currentPositiveNum++;
            }
            else return currentPositiveNum;
        }
        return currentPositiveNum;
    }

}
