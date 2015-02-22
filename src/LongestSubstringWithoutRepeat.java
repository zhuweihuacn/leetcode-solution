import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode's Implementation of Longest Substring Without Repeating Characters:
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Created by wei on 2/21/15.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Set<Character> uniqueCharSet = new HashSet<Character>();
        int start = 0, end = 0, ans = 0;

        while (end < s.length ()) {
            // How can we naming this algorithm called sliding window?
            // Selective Repeat ARQ will cry.
            char c = s.charAt (end);
            if (uniqueCharSet.contains (c)) {
                char startChar;
                do
                    uniqueCharSet.remove (startChar = s.charAt (start++));
                while (startChar != c);
            }
            uniqueCharSet.add (c);
            ans = Math.max (ans, ++end - start);
        }
        return ans;
    }
}
