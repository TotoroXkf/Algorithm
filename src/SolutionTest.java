import org.junit.Test;

import java.util.List;

import struct.ListNode;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        int[] array1 = new int[]{2, 0};
        int[] array2 = new int[]{1};
        solution.merge(array1, 1, array2, 1);
    }
} 
