import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assert result.get(0).equals("AAAAACCCCC");
        assert result.get(1).equals("CCCCCAAAAA");
    }
}