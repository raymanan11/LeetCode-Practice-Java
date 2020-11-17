public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//
//        int result = stringProblems.firstUniqChar("aadadaad");
//
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        arrayProblems.merge(nums1, 3, nums2,3);

//        int[] nums1 = {0};
//        int[] nums2 = {1};
//        arrayProblems.merge(nums1, 0, nums2,1);

    }
}
