
import java.util.*;

public class StringProblems {

    // Given a string s, find the length of the longest substring without repeating characters.

    // Input: s = "abcabcbb"
    // Output: 3
    // Explanation: The answer is "abc", with the length of 3.

    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (!uniqueChars.contains(s.charAt(i))) {
                uniqueChars.add(s.charAt(i));
                max = Math.max(max, uniqueChars.size());
                i++;
            }
            else {
                uniqueChars.remove(s.charAt(j));
                j++;
            }
        }
        return max;
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
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String key = String.valueOf(strArr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
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

    // Given two binary strings a and b, return their sum as a binary string.
    // Input: a = "1010"
    //        b = "1011"
    // Output: "10101"

    public String addBinary(String a, String b) {
        int carry = 0;
        int maxLength = a.length() >= b.length() ? a.length() : b.length();

        // Get the biggest string between the two
        String biggest = maxLength == a.length() ? a : b;
        // Get the smallest string between the two
        String smallest = maxLength == a.length() ? b : a;

        // make the smallest string have same length as biggest string by adding zeros to beginning of string
        int diff = maxLength - smallest.length();
        for (int i = 0; i < diff; i++) {
            smallest = "0".concat(smallest);
        }

        String result = "";

        // addition
        for (int i = 0; i < maxLength; i++) {
            int aNum = Character.getNumericValue(biggest.charAt(biggest.length() - 1 - i));
            int bNum = Character.getNumericValue(smallest.charAt(smallest.length() - 1 - i));
            int sum = aNum + bNum + carry;
            carry = sum / 2;
            result = String.valueOf(sum % 2).concat(result);
        }
        if (carry > 0) result = String.valueOf(carry).concat(result);
        return result;
    }

    // The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    // (you may want to display this pattern in a fixed font for better legibility)

    // P   A   H   N
    // A P L S I I G
    // Y   I   R

    // Input: s = "PAYPALISHIRING", numRows = 4
    // Output: "PINALSIGYAHRPI"
    // Explanation:
    // P     I    N
    // A   L S  I G
    // Y A   H R
    // P     I

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        String result = "";
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new ArrayList<>());
        }
        int num = numRows - 1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map.get(count).add(s.charAt(i));
            if (num == numRows - 1) count++;
            else if (num == 0) count--;
            if (count == numRows - 1) num = 0;
            if (count == 0) num = numRows - 1;
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            for(char c : entry.getValue()) {
                result = result.concat(String.valueOf(c));
            }
        }
        return result;
    }

    // Given an input string s, reverse the order of the words.
    // A word is defined as a sequence of non-space characters.
    // The words in s will be separated by at least one space.
    // Return a string of the words in reverse order concatenated by a single space.

    // Input: s = "  Bob    Loves  Alice   "       Input: s = "  hello world  "
    // Output: "Alice Loves Bob"                   Output: "world hello"

    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        String result = "";
        for (int i = 0; i < sArr.length; i++) {
            String currentWord = sArr[sArr.length - 1 - i];
            if (currentWord.length() > 0) result = result.concat(currentWord + " ");
        }
        return result.substring(0, result.length() - 1);
    }

    // Write a function that reverses a string. The input string is given as an array of characters char[].

    // Input: ["h","e","l","l","o"]
    // Output: ["o","l","l","e","h"]

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    // Write a function that takes a string as input and reverse only the vowels of a string.

    // Input: "hello"     Input: "leetcode"
    // Output: "holle"    Output: "leotcede"


    public String reverseVowels(String s) {
        char[] cArr = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        ArrayList<Integer> voweInindexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) voweInindexes.add(i);
        }
        for (int i = 0; i < voweInindexes.size() / 2; i++) {
            char temp = cArr[voweInindexes.get(i)];
            cArr[voweInindexes.get(i)] = cArr[voweInindexes.get(voweInindexes.size() - 1 - i)];
            cArr[voweInindexes.get(voweInindexes.size() - 1 - i)] = temp;
        }
        String result = "";
        for (int i = 0; i < cArr.length; i++) {
            result = result.concat(String.valueOf(cArr[i]));
        }
        return result;
    }

    // Given a non-empty string s, you may delete at most one character.
    // Judge whether you can make it a palindrome.

    // Input: "abca"
    // Output: True
    // Explanation: You could delete the character 'c'.

    public boolean validPalindrome(String s) {
        int middle = s.length() / 2;
        for (int i = 0; i < middle; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return isPal(s, i, j - 1) || isPal(s, i + 1, j);
            }
        }
        return true;
    }

    public boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // You are given a string s, return the number of segments in the string.
    // A segment is defined to be a contiguous sequence of non-space characters.

    public int countSegments(String s) {
        if (s.equals("")) return 0;
        int count = 0;
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("")) count++;
        }
        return count;
    }

    // Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
    // It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

    // Words in the list of banned words are given in lowercase, and free of punctuation.
    // Words in the paragraph are not case sensitive.  The answer is in lowercase.

    // Input:
    // paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    // banned = ["hit"]
    // Output: "ball"
    // Explanation:
    //         "hit" occurs 3 times, but it is a banned word.
    //         "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
    // Note that words in the paragraph are not case sensitive,
    // that punctuation is ignored (even if adjacent to words, such as "ball,"),
    // and that "hit" isn't the answer even though it occurs more because it is banned.

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] arr = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> bannedWords = new ArrayList<>();

        Collections.addAll(bannedWords, banned);

        for (String s : arr) {
            if (s.equals("")) continue;
            if (!map.containsKey(s)) map.put(s, 1);
            else {
                int recurring = map.get(s);
                map.put(s, recurring + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());


        for (int i = 0; i < list.size(); i++) {
            Map.Entry<String, Integer> map1 = list.get(list.size() - 1 - i);
            if (bannedWords.contains(map1.getKey())) {
                System.out.println(map1.getKey());
                continue;
            }
            System.out.println();
            return map1.getKey();
        }
        return "";
    }

    // Implement strStr().
    // Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    // Input: haystack = "hello", needle = "ll"
    // Output: 2

    public int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        char start;
        if (needleSize == 0) return 0;
        else start = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == start && (i + needleSize <= haystack.length())) {
                String substringHaystack = haystack.substring(i, i + needleSize);
                if (substringHaystack.equals(needle)) return i;
            }
        }
        return -1;
    }

    // Given an array of string words. Return all strings in words which is substring of another word in any order.
    // String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

    // Input: words = ["mass","as","hero","superhero"]
    // Output: ["as","hero"]
    // Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
    //         ["hero","as"] is also a valid answer.

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> uniqueSubstring = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].contains(words[j]) && i != j) {
                    uniqueSubstring.add(words[j]);
                }
            }
        }
        result.addAll(uniqueSubstring);
        return result;
    }

    // Given two strings A and B of lowercase letters, return true if you can swap two letters in A
    // so the result is equal to B, otherwise, return false.

    // Input: A = "aaaaaaabc", B = "aaaaaaacb"         Input: A = "ab", B = "ab"
    // Output: true                                    Output: false

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) return false;

        if (A.equals(B)) {
            Set<Character> letters = new HashSet<>();
            for(int i = 0; i < A.length(); i++) {
                if (!letters.contains(A.charAt(i))) letters.add(A.charAt(i));
                else return true;
            }
        }

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) indexes.add(i);
        }

        return indexes.size() == 2 &&
                A.charAt(indexes.get(0)) == B.charAt(indexes.get(1)) &&
                A.charAt(indexes.get(1)) == B.charAt(indexes.get(0));
    }

    // Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed,
    // and the character will be typed 1 or more times.

    // You examine the typed characters of the keyboard.
    // Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
    // put typed in an arraylist and remove every occurrance of character in name from typed

    // Input: name = "alex", typed = "aaleexa"
    // Output: true
    // Explanation: 'a' and 'e' in 'alex' were long pressed.

    public boolean isLongPressedName(String name, String typed) {
        int namePointer = 0;
        int typedPointer = 0;

        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();

        while (namePointer < nameChars.length && typedPointer < typedChars.length) {
            if (nameChars[namePointer] == typedChars[typedPointer]) {
                namePointer++;
                typedPointer++;
            }
            else if (typedPointer >= 1 && typedChars[typedPointer] == typedChars[typedPointer - 1]) typedPointer++;
            else return false;
        }

        if (namePointer < name.length()) return false;
        else {
            while (typedPointer < typedChars.length) {
                if (typedPointer >= 1 && typedChars[typedPointer] == typedChars[typedPointer - 1]) typedPointer++;
                else if (typedChars[typedPointer] != typedChars[typedPointer - 1]) return false;
            }
        }
        return true;
    }

    // For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence.
    // The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
    // If word is not a substring of sequence, word's maximum k-repeating value is 0.

    // Given strings sequence and word, return the maximum k-repeating value of word in sequence.

    public int maxRepeating(String sequence, String word) {
        int repeating = 0;
        String repeatingString = word;
        while (true) {
            if (sequence.contains(repeatingString)) {
                repeating++;
                repeatingString = repeatingString.concat(word);
            }
            else return repeating;
        }
    }

    // Given a non-empty string check if it can be constructed by taking a substring of it and
    // appending multiple copies of the substring together.

    // Input: "abcabcabcabc"
    // Output: True
    // Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

    public boolean repeatedSubstringPattern(String s) {
        int end = 1;
        String sub = s.substring(0, end);
        String substring = sub;
        int count = 0;

        while (true) {
            if (s.contains(substring)) {
                count++;
                substring = substring.concat(sub);
                if (substring.equals(s) && count > 0) return true;
                if (substring.equals(s) && count == 0 || substring.length() > s.length()) return false;
            }
            else {
                count = 0;
                end += 1;
                sub = s.substring(0, end);
                substring = sub;
            }
        }
    }

    // Given a string s, return the longest palindromic substring in s.

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int pal1 = expandAroundCenter(s, i, i);
            int pal2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(pal1, pal2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + (max / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    // Implement an algorithm to determine if a string has all unique characters.
    // What if you cannot use additional data structures.

    // Input: battery
    // Output false

    public boolean isUnique(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (str.indexOf(String.valueOf(s.charAt(i))) < 0) str.append(s.charAt(i));
            else return false;
        }
        return true;
    }

    // Check Permutation: Given two strings, write a method to decide if one is a permutation of the
    // other.

    public boolean checkPermutation(String a, String b) {
        char[] aCharArr = a.toCharArray();
        char[] bCharArr = b.toCharArray();
        Arrays.sort(aCharArr);
        Arrays.sort(bCharArr);
        return Arrays.equals(aCharArr, bCharArr);
    }

    // URLify: Write a method to replace all spaces in a string with '%2e: You may assume that the string
    // has sufficient space at the end to hold the additional characters, and that you are given the "true"
    // length of the string. (Note: if implementing in Java, please use a character array so that you can
    // perform this operation in place.)
    // EXAMPLE
    // Input: "Mr John Smith     ", 13
    // Output: "Mr%2eJohn%2eSmith"

    public void URLify(char[] arr, int trueLength) {
        int numSpaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (arr[i] == ' ') numSpaces++;
        }
        int index = trueLength + numSpaces * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[index - 1] = '0';
                arr[index - 2] = '2';
                arr[index - 3] = '%';
                index -= 3;
            }
            else {
                arr[index - 1] = arr[i];
                index--;
            }
        }
    }

    // Palindrome Permutation: Given a string, write a function to check if it is a permutation of
    // a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
    // permutation is a rearrangement of letters. The palindrome does not need to be limited to just
    // dictionary words.
    // EXAMPLE
    // Input: Tact Coa
    // Output: True (permutations:"taco cat'; "atco cta'; etc.)

    public boolean isPalindromePermutation(String s) {
        int numOnes = 0;
        if (s.equals("")) return true;
        s = s.toLowerCase().replaceAll(" ", "");
        Map<Character, Integer> charCount = new HashMap<>();
        // gets the number of occurences that each letter has
        for (int i = 0; i < s.length(); i++) {
            if (!charCount.containsKey(s.charAt(i))) charCount.put(s.charAt(i), 1);
            else {
                int occurrence = charCount.get(s.charAt(i));
                charCount.put(s.charAt(i), occurrence + 1);
            }
        }
        for (Map.Entry<Character, Integer> map : charCount.entrySet()) {
            // number of occurences is > 1 and odd then not a palindrome
            if (map.getValue() > 1 && map.getValue() % 2 > 0) return false;
            else if (map.getValue() == 1) numOnes++;
        }
        // have at most one 1 which serves as the center but if more than one 1 then not a palindrome
        return numOnes <= 1;
    }

    // One Away: There are three types of edits that can be performed on strings: insert a character,
    // remove a character, or replace a character. Given two strings, write a function to check if they are
    // one edit (or zero edits) away.
    // EXAMPLE
    // pale, ple -> true
    // pales, pale -> true
    // pale, bale -> true
    // pale, bake -)> false

    public boolean oneAway(String a, String b) {
        if (a.length() - b.length() == 1) {
            System.out.println("a");
            return insertRemoveCheck(a, b);
        }
        else if (a.length() - b.length() == -1) {
            System.out.println("b");
            return insertRemoveCheck(b, a);
        }
        else if (a.length() == b.length()) {
            System.out.println("c");
            return sameLengthCheck(a, b);
        }
        System.out.println("d");
        return false;
    }

    public boolean insertRemoveCheck(String bigger, String smaller) {
        int i = 0;
        int j = 0;

        while (i < bigger.length() && j < smaller.length()) {
            if (bigger.charAt(i) != smaller.charAt(j)) {
                if (i != j) return false;
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    public boolean sameLengthCheck(String a, String b) {
        boolean difference = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (difference) return false;
                difference = true;
            }
        }
        return true;
    }

    // String Compression: Implement a method to perform basic string compression using the counts
    // of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    // "compressed" string would not become smaller than the original string, your method should return
    // the original string. You can assume the string has only uppercase and lowercase letters (a - z).

    public String stringCompression(String s) {

        StringBuilder compressedString = new StringBuilder();

        char previous = ' ';
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (previous != s.charAt(i)) {
                if (count > 0) {
                    compressedString.append(previous);
                    compressedString.append(count);
                }
                previous = s.charAt(i);
                count = 1;
            }
            else if (previous == s.charAt(i)) {
                count++;
            }
            if (i == s.length() - 1) {
                compressedString.append(previous);
                compressedString.append(count);
            }
        }

        return (compressedString.toString().length() < s.length()) ? compressedString.toString() : s;
    }

    public void reverseMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    // Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for (int col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

    }

    // String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
    // of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
    // call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;

        return A.concat(A).contains(B);
    }

}



