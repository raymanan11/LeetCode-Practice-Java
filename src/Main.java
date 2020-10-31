import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayProblems arrayProblems = new ArrayProblems();

        int[] nums = {0, -1, 4, 2, 7,-3, 10};

        int result = arrayProblems.fourLargest(nums);

        System.out.println(result);

    }
}
