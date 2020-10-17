import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[] array = new int[]{2, 3, 1, 2, 4, 4};
        int target = 7;
        assert 2 == solution.minSubArrayLen(target, array);
    }

    @Test
    public void check1() {
        int[] array = new int[]{10, 3, 1, 2, 4, 4};
        int target = 7;
        assert 1 == solution.minSubArrayLen(target, array);
    }

    @Test
    public void check2() {
        int[] array = new int[]{1, 1};
        int target = 3;
        assert 0 == solution.minSubArrayLen(target, array);
    }

    @Test
    public void check3() {

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