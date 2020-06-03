import org.junit.Test;

import struct.ListNode;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        ListNode head = testCase.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseBetween(head, 2, 4);
        testCase.matchLinkedList(result, testCase.createLinkedList(new int[]{1, 4, 3, 2, 5}));
    }
} 
