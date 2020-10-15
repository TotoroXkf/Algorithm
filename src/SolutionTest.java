import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int n = 2;
        int[][] array = new int[][]{
            new int[]{
                1, 0
            }
        };
        assert solution.canFinish(n, array);
    }

    @Test
    public void check1() {
        int n = 2;
        int[][] array = new int[][]{
            new int[]{
                1, 0
            },
            new int[]{
                0, 1
            }
        };
        assert !solution.canFinish(n, array);
    }

    @Test
    public void check2() {
        int n = 3;
        int[][] array = new int[][]{
            new int[]{
                0, 1
            },
            new int[]{
                1, 2
            },
            new int[]{
                2, 0
            }
        };
        assert !solution.canFinish(n, array);
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

    @Test
    public void check10() {

    }
}