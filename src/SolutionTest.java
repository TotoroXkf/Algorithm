import org.junit.Test;

import java.util.List;

import struct.ListNode;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        int n = 2;
        List<Integer> result = solution.grayCode(n);
        testCase.matchArray(result.toArray(), new Object[]{0, 1, 3, 2});

        n = 1;
        result = solution.grayCode(n);
        testCase.matchArray(result.toArray(), new Object[]{0, 1});

        n = 3;
        result = solution.grayCode(n);
        testCase.matchArray(result.toArray(), new Object[]{0, 1, 3, 2, 6, 7, 5, 4});
    }
} 
