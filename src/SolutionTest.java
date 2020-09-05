import org.junit.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        solution.sortList(head);
    }
} 
