public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        int result = stringProblems.lengthOfLastWord("Hello World");
//        System.out.println(result);
//
        ArrayProblems arrayProblems = new ArrayProblems();

        int[] nums1 = {0,1,2,2,3,0,4,2};
        int result = arrayProblems.removeElement(nums1, 2);

        System.out.println(result);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
}
