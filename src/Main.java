public class Main {

    public static void main(String[] args) {

//        StringProblems stringProblems = new StringProblems();
//        String result = stringProblems.convert("PAYPALISHIRING", 3);
//        System.out.println(result);

        ArrayProblems arrayProblems = new ArrayProblems();

        int[] nums = {0,2,2,1,1};
        int result = arrayProblems.firstMissingPositive(nums);
        System.out.println(result);

    }
}
