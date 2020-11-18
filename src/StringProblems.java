
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

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    // Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    // Input: strs = ["eat","tea","tan","ate","nat","bat"]
    // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List> result = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] cArr = strs[i].toCharArray();
            Arrays.sort(cArr);
            String cArrString = String.valueOf(cArr);
            // if the ordered cArr string is not in the map, then you add it to the map with a new Arraylist
            if (!result.containsKey(cArrString)) result.put(cArrString, new ArrayList());
            // at this point the map will have the key since it'll either be added in prev step or already added
            // then you get the ArrayList from the key and add the corresponding string
            result.get(cArrString).add(strs[i]);
        }

        return new ArrayList(result.values());

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // keeps on substring until the prefix exists in the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // Determine whether an integer is a palindrome.
    // An integer is a palindrome when it reads the same backward as forward.


    // Input: x = 121    Input: x = -121
    // Output: true      Output: false

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    // Given a string, find the first non-repeating character in it and return its index.
    // If it doesn't exist, return -1.

    // s = "leetcode"
    // return 0.

    // s = "loveleetcode"
    // return 2.

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        // put the characters in the map with the character's latest occurrence as the value
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            // if the first occurrence of that character equals the latest occurrence of the character in map
            // return it
            if (s.indexOf(c) == map.get(c)) return i;
        }
        return -1;
    }

    // Given a string s consists of some words separated by spaces,
    // return the length of the last word in the string. If the last word does not exist, return 0.

    // Input: s = "Hello World"
    // Output: 5

    public int lengthOfLastWord(String s) {
        String[] result = s.split(" ");
        if (result.length == 0) return 0;
        return result[result.length - 1].length();
    }

}


