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

    @Test
    public void check2() {
        int[] array = new int[]{1, 4, 7, 2, 5, 8, 0, 3, 6, 9};
        assert "9876543210".equals(solution.largestNumber(array));
    }

    @Test
    public void check3() {
        int[] array = new int[]{121, 12};
        assert "12121".equals(solution.largestNumber(array));
    }

    @Test
    public void check4() {
        int[] array = new int[]{1212, 12};
        assert "121212".equals(solution.largestNumber(array));
    }

    @Test
    public void check5() {
        int[] array = new int[]{1212, 1212};
        assert "12121212".equals(solution.largestNumber(array));
    }

    @Test
    public void check6() {
        int[] array = new int[]{0, 0};
        assert "0".equals(solution.largestNumber(array));
    }
}