import org.junit.Test;

import java.util.List;

import struct.ListNode;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        String str1 = "great";
        String str2 = "rgeat";
        assert solution.isScramble(str1, str2);

        str1 = "great";
        str2 = "rgtae";
        assert solution.isScramble(str1, str2);

        str1 = "abcde";
        str2 = "caebd";
        assert !solution.isScramble(str1, str2);

        str1 = "abc";
        str2 = "bca";
        assert solution.isScramble(str1, str2);

        str1 = "ccabcbabcbabbbbcbb";
        str2 = "bbbbabccccbbbabcba";
        assert !solution.isScramble(str1, str2);
    }
} 
