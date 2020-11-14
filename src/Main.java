import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringProblems stringProblems = new StringProblems();

        String[] strs = {"c","acc","ccc"};
        String result = stringProblems.longestCommonPrefix(strs);

        System.out.println(result);

    }
}
