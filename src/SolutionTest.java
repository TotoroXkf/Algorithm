import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        char[][] nums = new char[][]{
            new char[]{'1', '0', '1', '0', '0'},
            new char[]{'1', '0', '1', '1', '1'},
            new char[]{'1', '1', '1', '1', '1'},
            new char[]{'1', '0', '0', '1', '0'}
        };
        assert solution.maximalSquare(nums) == 4;
    }

    @Test
    public void check1() {
        char[][] nums = new char[][]{
            new char[]{'0', '1'},
            new char[]{'0', '1'}
        };
        assert solution.maximalSquare(nums) == 1;
    }

    @Test
    public void check2() {
        char[][] nums = new char[][]{
            new char[]{'1', '1', '1', '1', '0'},
            new char[]{'1', '1', '1', '1', '0'},
            new char[]{'1', '1', '1', '1', '1'},
            new char[]{'1', '1', '1', '1', '1'},
            new char[]{'0', '0', '1', '1', '1'}
        };
        assert solution.maximalSquare(nums) == 16;
    }

    @Test
    public void check3() {

    }

    @Test
    public void check4() {

    }

    @Test
    public void check5() {

    }

    @Test
    public void check6() {

    }

    @Test
    public void check7() {

    }

    @Test
    public void check8() {

    }

    @Test
    public void check9() {

    }
}