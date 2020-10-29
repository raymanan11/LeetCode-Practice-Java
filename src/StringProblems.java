
import java.util.*;

public class StringProblems {

    // Given a string s, find the length of the longest substring without repeating characters.

    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.

    public int lengthOfLongestSubstring(String s) {

        Set<Character> results = new HashSet<>();

        int currentIndex = 0;
        int deleteIndex = 0;

        int longestSubstring = 0;

        while (currentIndex < s.length()) {
            // if the set doesn't contain the character then add it to the set and update the longest substring
            if (!results.contains(s.charAt(currentIndex))) {
                results.add(s.charAt(currentIndex));
                longestSubstring = Math.max(longestSubstring, results.size());
                currentIndex++;
            }
            // if it does then keep removing from the set until that character is gone
            else {
                results.remove(s.charAt(deleteIndex));
                deleteIndex++;
            }
        }

        return longestSubstring;
    }

    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.

    //An input string is valid if:

    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.

    // Input: s = "()[]{}"   Input: s = "([)]"
    // Output: true          Output: true


    public boolean isValid(String s) {

        if (s.length() < 2) return false;

        char openParen = '(', closeParen = ')',
                openCurly = '{', closeCurly = '}',
                openBracket = '[', closeBracket = ']';

        LinkedList<Character> openBrackets = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            // if any open bracket, push into the stack
            if (s.charAt(i) == openParen || s.charAt(i) == openCurly || s.charAt(i) == openBracket)
                openBrackets.push(s.charAt(i));

            // if any closing bracket and there is something in stack, pop off the stack
            // and if not matching then return false
            else if (s.charAt(i) == closeParen && openBrackets.size() > 0) {
                char openCharacter = openBrackets.pop();
                if (openCharacter != openParen) {
                    return false;
                }
            }
            else if (s.charAt(i) == closeCurly && openBrackets.size() > 0) {
                char openCharacter = openBrackets.pop();
                if (openCharacter != openCurly) {
                    return false;
                }
            }
            else if (s.charAt(i) == closeBracket && openBrackets.size() > 0) {
                char openCharacter = openBrackets.pop();
                if (openCharacter != openBracket) {
                    return false;
                }
            }

            // if there is a closing bracket, and stack is empty, then no way to balance it so return false
            else if (s.charAt(i) == closeParen || s.charAt(i) == closeCurly || s.charAt(i) == closeBracket
                    && openBrackets.size() == 0) return false;
        }

        return openBrackets.isEmpty();
    }

    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    // Note: For the purpose of this problem, we define empty string as valid palindrome.

    // Input: "A man, a plan, a canal: Panama"
    // Output: true

    // Input: "race a car"
    // Output: false

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int middle = s.length() / 2;
        System.out.println(s);
        int j;
        for (int i = 0; i < middle; i++) {
            j = s.length() - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    // Given two strings s and t , write a function to determine if t is an anagram of s.

    // Input: s = "anagram", t = "nagaram"     Input: s = "rat", t = "car"
    // Output: true                            Output: false

    public boolean isAnagram(String s, String t) {

        if (t.length() > s.length()) return false;

        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            characters.add(i, s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            if (characters.contains(t.charAt(i))) {
                characters.remove(Character.valueOf(t.charAt(i)));
            }
        }
        return characters.size() == 0;
    }
}



























//        int left = 0;
//        int right = 0;
//
//        Set<Character> results = new HashSet<>();
//        int largestSubstring = 0;

//        while (right < s.length()) {
//            if (!results.contains(s.charAt(right))) {
//                results.add(s.charAt(right));
//                System.out.println("Character added to set: " + s.charAt(right));
//                System.out.println(results);
//                largestSubstring = Math.max(largestSubstring, results.size());
//                System.out.println("Largest substring: " + largestSubstring);
//                right++;
//            }
//            else {
//                results.remove(s.charAt(left));
//                System.out.println("Removed from set: " + s.charAt(left));
//                left++;
//            }
//        }
