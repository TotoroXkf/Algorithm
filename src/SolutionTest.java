import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        assert solution.numTrees(1) == 1;
        assert solution.numTrees(2) == 2;
        assert solution.numTrees(3) == 5;
    }
} 
