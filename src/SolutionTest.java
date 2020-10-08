import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(array, 3);
        assert array[0] == 5;
        assert array[1] == 6;
        assert array[2] == 7;
        assert array[3] == 1;
        assert array[4] == 2;
        assert array[5] == 3;
        assert array[6] == 4;
    }

    @Test
    public void check1() {
        int[] array = new int[]{1, 2, 3, 4};
        solution.rotate(array, 2);
        assert array[0] == 3;
        assert array[1] == 4;
        assert array[2] == 1;
        assert array[3] == 2;
    }
}