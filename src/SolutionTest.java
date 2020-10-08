import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int k = 2;
        int[] array = new int[]{2, 4, 1};
        assert 2 == solution.maxProfit(k, array);
    }

    @Test
    public void check2() {
        int k = 2;
        int[] array = new int[]{3, 2, 6, 5, 0, 3};
        assert 7 == solution.maxProfit(k, array);
    }

    @Test
    public void check3() {
        int k = 2;
        int[] array = new int[]{6, 1, 3, 2, 4, 7};
        assert 7 == solution.maxProfit(k, array);
    }

    @Test
    public void check4() {
        int k = 2;
        int[] array = new int[]{4, 1, 2};
        assert 1 == solution.maxProfit(k, array);
    }

    @Test
    public void check5() {
        int k = 2;
        int[] array = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        assert 13 == solution.maxProfit(k, array);
    }

    @Test
    public void check6() {
        int k = 2;
        int[] array = new int[]{6, 5, 4, 8, 6, 8, 7, 8, 9, 4, 5};
        assert 7 == solution.maxProfit(k, array);
    }
}