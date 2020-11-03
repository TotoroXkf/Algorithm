import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;
        int t = 0;
        assert solution.containsNearbyAlmostDuplicate(nums, k, t);
    }

    @Test
    public void check1() {
        int[] nums = new int[]{1, 0, 1, 1};
        int k = 1;
        int t = 2;
        assert solution.containsNearbyAlmostDuplicate(nums, k, t);
    }

    @Test
    public void check2() {
        int[] nums = new int[]{1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        assert !solution.containsNearbyAlmostDuplicate(nums, k, t);
    }

    @Test
    public void check3() {
        int[] nums = new int[]{-2147483648,2147483647};
        int k = 1;
        int t = 1;
        assert !solution.containsNearbyAlmostDuplicate(nums, k, t);
    }

    @Test
    public void check4() {

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