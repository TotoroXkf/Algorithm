import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[][] map = new int[][]{
            new int[]{-2, -3, 3},
            new int[]{-5, -10, 1},
            new int[]{10, 30, -5}
        };
        assert 7 == solution.calculateMinimumHP(map);
    }

    @Test
    public void check2() {
        int[][] map = new int[][]{
            new int[]{0, 0, 0},
            new int[]{1, 1, 1},
        };
        assert 1 == solution.calculateMinimumHP(map);
    }

    @Test
    public void check3() {
        int[][] map = new int[][]{
            new int[]{1, -3, 3},
            new int[]{0, -2, 0},
            new int[]{-3, -3, -3}
        };
        assert 3 == solution.calculateMinimumHP(map);
    }
}