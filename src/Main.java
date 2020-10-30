import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringProblems s = new StringProblems();

        String[] arr = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = s.groupAnagrams(arr);
        System.out.println(result);

    }

}
