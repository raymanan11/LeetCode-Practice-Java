import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringProblems stringProblems = new StringProblems();

        String s = "0P";

        boolean result = stringProblems.isPalindrome(s);

        if (result) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

}
