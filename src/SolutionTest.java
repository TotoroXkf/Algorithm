import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int m = 0;
        int n = 1;
        assert 0 == solution.rangeBitwiseAnd(m, n);
    }

    @Test
    public void check2() {
        int m = 2;
        int n = 3;
        assert 2 == solution.rangeBitwiseAnd(m, n);
    }

    @Test
    public void check3() {
        int m = 14;
        int n = 19;
        assert 0 == solution.rangeBitwiseAnd(m, n);
    }
}