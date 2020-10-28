import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[] nums = new int[]{3, 6, 1, 8, 2, 7, 23, 6, 8, 0, 3};
        assert solution.findKthLargest(nums, 1) == 23;
    }

    @Test
    public void check1() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        assert solution.findKthLargest(nums, 2) == 5;
    }

    @Test
    public void check2() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        assert solution.findKthLargest(nums, 4) == 4;
    }

    @Test
    public void check3() {
        int[] nums = new int[]{1};
        assert solution.findKthLargest(nums, 1) == 1;
    }

    @Test
    public void check4() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        assert solution.findKthLargest(nums, 20) == 2;
    }

    @Test
    public void check5() {

    }

    @Test
    public void check6() {

    }

    @Test
    public void check7() {

    }

    @Test
    public void check8() {

    }

    @Test
    public void check9() {

    }

    @Test
    public void check10() {

    }
}