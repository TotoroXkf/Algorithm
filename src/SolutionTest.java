import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void findMin() {
        assert "2".equals(solution.fractionToDecimal(2, 1));
        assert "0.5".equals(solution.fractionToDecimal(1, 2));
        assert "0.(6)".equals(solution.fractionToDecimal(2, 3));
        assert "0.1(6)".equals(solution.fractionToDecimal(1, 6));
        assert "0.(4)".equals(solution.fractionToDecimal(4, 9));
    }
}