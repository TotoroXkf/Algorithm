import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        assert solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        assert !solution.isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }
} 
