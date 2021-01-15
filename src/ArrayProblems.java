
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
            result *= nums[nums.length - i] - 1;
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

    // Given a sorted array of distinct integers and a target value, return the index if the target is found.
    // If not, return the index where it would be if it were inserted in order.

    // Input: nums = [1,3,5,6], target = 5     Input: nums = [1,3,5,6], target = 2
    // Output: 2                               Output: 1

    public int searchInsert(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.containsKey(target)) return map.get(target);

        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i]) return i;
        }
        return nums.length;
    }

    // Given a sorted array nums, remove the duplicates in-place such that duplicates
    // appeared at most twice and return the new length.

    // Input: nums = [0,0,1,1,1,1,2,3,3]
    // Output: 7, nums = [0,0,1,1,2,3,3]

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int count = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j] && count < 2) {
                i++;
                count++;
                nums[i] = nums[j];
            }
            else if (nums[i] != nums[j]) {
                i++;
                count = 1;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    // Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

    // Input: 5
    // Output:
    //        [
    //        [1],
    //        [1,1],
    //        [1,2,1],
    //        [1,3,3,1],
    //        [1,4,6,4,1]
    //        ]

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        List<Integer> row;
        List<Integer> previousRow;
        for (int i = 1; i < numRows; i++) {
            previousRow = result.get(i - 1);
            row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(previousRow.get(j) + previousRow.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    // Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
    // Notice that the row index starts from 0.

    public List<Integer> getRow(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows + 1; i++) {
            List<Integer> pascalRow = new ArrayList<>();
            List<Integer> previousRow = result.get(i - 1);
            pascalRow.add(1);

            for (int j = 1; j < i; j++) {
                int numberToAdd = previousRow.get(j - 1) + previousRow.get(j);
                pascalRow.add(numberToAdd);
            }

            pascalRow.add(1);
            result.add(pascalRow);
        }

        return result.get(numRows);
    }


    // Given an array of integers and an integer k, find out whether there are two distinct indices i and j
    // in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

    // Input: nums = [1,0,1,1], k = 1    Input: nums = [1,2,3,1,2,3], k = 2
    // Output: true                      Output: false

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexes.containsKey(nums[i])) indexes.put(nums[i], i);
            else if (Math.abs(indexes.get(nums[i]) - i) <= k) return true;
            else indexes.put(nums[i], i);
        }
        return false;
    }

    // Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
    // Output: [8,6,2,4]
    // Explanation:
    // At the beginning, the array is [1,2,3,4].
    // After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
    // After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
    // After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
    // After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int sum = 0;
        for (int num : A) {
            if (num % 2 == 0) sum += num;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (A[query[1]] % 2 == 0) sum = sum - A[query[1]];
            A[query[1]] = A[query[1]] + query[0];
            if (A[query[1]] % 2 == 0) sum += A[query[1]];
            result[i] = sum;
        }
        return result;
    }

    // Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
    // Return that integer.

    // Input: arr = [1,2,2,6,6,6,6,7,10]
    // Output: 6

    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) return arr[0];
        int twentyFivePercent = arr.length / 4;
        Map<Integer, Integer> numOccurrences = new HashMap<>();
        for (int num : arr) {
            if (!numOccurrences.containsKey(num)) numOccurrences.put(num, 1);
            else {
                int addOne = numOccurrences.get(num) + 1;
                numOccurrences.put(num, addOne);
                if (numOccurrences.get(num) > twentyFivePercent) return num;
            }
        }
        return 0;
    }

    // Given an array arr, replace every element in that array with the greatest element
    // among the elements to its right, and replace the last element with -1.
    // After doing so, return the array

    // Input: arr = [17,18,5,4,6,1]
    // Output: [18,6,6,6,1,-1]

    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int max = 0;
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> group = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 10) {
                max = 1;
                group.put(i, 1);
            }
            else {
                int total = 0;
                int inum = i;
                while (inum != 0) {
                    total += inum % 10;
                    inum /= 10;
                }
                if (!group.containsKey(total)) {
                    group.put(total, 1);
                    continue;
                }
                int num = group.get(total) + 1;
                group.put(total, num);
                max = Math.max(max, num);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> map : group.entrySet()) {
            if (map.getValue() == max) count++;
        }
        return count;
    }

    // You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

    // To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

    // If k > 0, replace the ith number with the sum of the next k numbers.
    // If k < 0, replace the ith number with the sum of the previous k numbers.
    // If k == 0, replace the ith number with 0.

    // Input: code = [5,7,1,4], k = 3
    // Output: [12,10,16,13]
    // Explanation: Each number is replaced by the sum of the next 3 numbers.
    // The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
    // To get 5 after 4, 3 (index) mod 4 (length of array), 7 -> 4 mod 4 = 0

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        int size = code.length;
        for (int i = 0; i < size; i++) {
            int total = 0;
            if (k > 0) {
                for (int j = i + 1; j <= i + k; j++) {
                    total += code[j % size];
                }
                System.out.println(total);
                result[i] = total;
            }
            else if (k < 0) {
                for (int j = i - 1; j >= i + k; j--) {
                    total += code[(j % size + size) % size];
                }
                System.out.println();
                result[i] = total;
            }
            else {
                for (int j = 0; j < size; j++) {
                    result[i] = 0;
                }
            }
        }
        return result;
    }

    // Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
    // Return a lucky integer in the array. If there are multiple lucky integers return the largest of them.
    // If there is no lucky integer return -1

    // Input: arr = [2,2,3,4]
    // Output: 2
    // Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

    public int findLucky(int[] arr) {

        Map<Integer, Integer> frequency = new HashMap<>();
        int max = -1;

        for (int num : arr) {
            if (!frequency.containsKey(num)) frequency.put(num, 1);
            else {
                int frequencyPlusOne = frequency.get(num) + 1;
                frequency.put(num, frequencyPlusOne);
            }
        }

        for (Map.Entry<Integer, Integer> map : frequency.entrySet())
            if (map.getKey().equals(map.getValue())) max = Math.max(map.getKey(), max);

        return max;
    }

    // Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    // n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
    // Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * Math.abs(left - right));
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }

    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
            }
            else if (nums[i] == 2) {
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
                i--;
            }
        }
    }

    // Given an array of size n, find the majority element.
    // The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    // You may assume that the array is non-empty and the majority element
    // always exist in the array.

    // Input: [2,2,1,1,1,2,2]
    // Output: 2

    public int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!occurrence.containsKey(nums[i])) occurrence.put(nums[i], 1);
            else {
                int numOccurence = occurrence.get(nums[i]);
                occurrence.put(nums[i], numOccurence + 1);
            }
        }

        System.out.println(occurrence);
        for (Map.Entry<Integer, Integer> map : occurrence.entrySet()) {
            if (map.getValue() > majority) return map.getKey();
        }
        return 0;
    }

    // Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as
    // a binary number (from most-significant-bit to least-significant-bit.)

    // Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int num = 0;
        for (int number : A) {
            num += number;
            result.add(num % 5 == 0);
            num *= 2;
            // continuously change numbers such as 6 to 1 to make it easier to calculate instead of bigger numbers
            num %= 5;
        }
        return result;
    }

    // Given an array of integers arr, replace each element with its rank.

    // The rank represents how large the element is. The rank has the following rules:

    // Rank is an integer starting from 1.
    // The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
    // Rank should be as small as possible.

    // Input: arr = [40,10,20,30]
    // Output: [4,1,2,3]

    public int[] arrayRankTransform(int[] arr) {
        int rank = 1;
        Map<Integer, Integer> rankings = new HashMap<>();

        // original order of array numbers
        List<Integer> original = new ArrayList<>();
        for (int num : arr) {
            original.add(num);
        }

        Arrays.sort(arr);

        // the rankings of the numbers put into a map
        for (int num : arr) {
            if (!rankings.containsKey(num)) {
                rankings.put(num, rank);
                rank++;
            }
        }

        int size = original.size();
        for (int i = 0; i < size; i++) {
            int currentRank = rankings.get(original.get(i));
            arr[i] = currentRank;
        }

        return arr;
    }

    // Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

    // Input: nums = [1,2,3,4]   Input: [-100,-98,-1,2,3,4]
    // Output: 24                Output: 39200

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }

    // Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
    // if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be
    // rotated to be equal to another domino.

    // Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length,
    // and dominoes[i] is equivalent to dominoes[j].

    // Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
    // Output: 1

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> unique = new HashMap<>();

        // sort all of inner arrays so able to find duplicates (i.e. {2,1} & {1,2} = {1,2} & {1,2}
        for (int[] pairs : dominoes) {
            Arrays.sort(pairs);
        }

        // get the number of recurrences for each unique domino
        for (int[] pairs : dominoes) {
            String pair = pairs[0] + "," + pairs[1];
            if (!unique.containsKey(pair)) unique.put(pair, 0);
            else {
                int repeats = unique.get(pair);
                unique.put(pair, repeats + 1);
            }
        }

        // for each of the unique dominoes, use the number of recurrences to calculate number of pairs
        // and add them to the result
        int result = 0;
        for (Map.Entry<String, Integer> map : unique.entrySet()) {
            if (map.getValue() > 0)
                result += numPairs(map.getValue());
        }
        return result;
    }

    public int numPairs(int repeating) {
        if (repeating == 1) return 1;
        return repeating + numPairs(repeating - 1);
    }

    // Given integer array nums, return the third maximum number in this array.
    // If the third maximum does not exist, return the maximum number.

    // Input: nums = [3,2,1]                     Input: nums = [2,2,3,1]
    // Output: 1                                 Output: 1
    // Explanation: The third maximum is 1.

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> unique = new HashSet<>();
        int lastOccurence = nums.length - 1;
        int three = 3;
        if (nums.length < 3) return nums[lastOccurence];
        while (three > 0 && lastOccurence >= 0) {
            // only subtract three if it's a unique number
            if (!unique.contains(nums[lastOccurence])) {
                unique.add(nums[lastOccurence]);
                three--;
            }
            lastOccurence--;
        }
        return (unique.size() >= 3) ? nums[lastOccurence + 1] : nums[nums.length - 1];
    }

    // Given an array of integers arr, return true if and only if it is a valid mountain array.

    // Input: arr = [0,2,3,4,5,2,1,0]      Input: arr = [0,2,3,3,5,2,1,0]
    // Output: true                        Output: false

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int maxNumber = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
                maxIndex = i;
            }
        }

        // if the maxIndex is first or last element in array, then it can't be a mountain
        if (maxIndex == 0 || maxIndex == arr.length - 1) return false;

        // check if strictly increasing from the left, if not return false
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= maxIndex; i++) {
            if (arr[i] > max) max = arr[i];
            else return false;
        }
        // check if strictly decreasing from the right, if not return false
        max = maxNumber;
        for (int i = maxIndex + 1; i < arr.length; i++) {
            if (arr[i] < max) max = arr[i];
            else return false;
        }

        return true;
    }

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.size() && bIndex < b.size()) {
            int aNum = a.get(aIndex);
            int bNum  = b.get(bIndex);
            if (aNum < bNum) {
                result.add(aNum);
                aIndex++;
            }
            else {
                result.add(bNum);
                bIndex++;
            }
        }
        if (aIndex != a.size() - 1) {
            while (aIndex < a.size()) {
                result.add(a.get(aIndex));
                aIndex++;
            }
        }
        if (bIndex != b.size() - 1) {
            while (bIndex < b.size()) {
                result.add(b.get(bIndex));
                bIndex++;
            }
        }
        return result;
    }

    public static List<String> funWithAnagrams(List<String> text) {
        // Write your code here
        List<String> result = new ArrayList<>();
        Set<String> uniqueAnagrams = new HashSet<>();
        for (String possibleAnagrams : text) {
            char[] charAnagram = possibleAnagrams.toCharArray();
            Arrays.sort(charAnagram);
            String sortedAnagram = new String(charAnagram);
            if (!uniqueAnagrams.contains(sortedAnagram)) {
                uniqueAnagrams.add(sortedAnagram);
                result.add(possibleAnagrams);
            }
        }
        Collections.sort(result);
        return result;
    }


}
