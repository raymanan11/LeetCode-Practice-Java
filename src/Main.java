public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        String result = stringProblems.reverseWords("  Bob    Loves  Alice   ");
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();

        int[] nums = {-5, -3, -1, 1, 4, 6};
        int result = arrayProblems.searchInsert(nums, -6);
        System.out.println(result);

    }
}
