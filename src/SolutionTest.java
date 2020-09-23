import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void findMin() {
        assert 1 == solution.titleToNumber("A");
        assert 28 == solution.titleToNumber("AB");
        assert 701 == solution.titleToNumber("ZY");
    }
}