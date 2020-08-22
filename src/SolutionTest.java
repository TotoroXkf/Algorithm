import org.junit.Test;

import utils.Case;

public class SolutionTest {
    private final Solution solution = new Solution();
    private final Case testCase = new Case();

    @Test
    public void test() {
        assert 0 == solution.longestConsecutive(testCase.parseToArray("[]"));
        assert 1 == solution.longestConsecutive(testCase.parseToArray("[1, 1, 1, 1]"));
        assert 4 == solution.longestConsecutive(testCase.parseToArray("[100, 4, 200, 1, 3, 2]"));
        assert 2 == solution.longestConsecutive(testCase.parseToArray("[0, -1]"));
        assert 2 == solution.longestConsecutive(testCase.parseToArray("[0, 0, -1]"));
        assert 3 == solution.longestConsecutive(testCase.parseToArray("[1, 2, 0, 1]"));
    }
} 
