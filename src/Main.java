import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringProblems stringProblems = new StringProblems();

        String s = ")(){}";

        boolean result = stringProblems.isValid(s);

        if (result) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

}
