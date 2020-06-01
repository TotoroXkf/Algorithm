import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        assert solution.numDecodings("12") == 2;
        assert solution.numDecodings("226") == 3;
        assert solution.numDecodings("4156") == 2;
    }
} 
