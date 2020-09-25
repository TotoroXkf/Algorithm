import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[] array = new int[]{10, 2};
        assert "210".equals(solution.largestNumber(array));
    }

    @Test
    public void check1() {
        int[] array = new int[]{3, 30, 34, 5, 9};
        assert "9534330".equals(solution.largestNumber(array));
    }
}