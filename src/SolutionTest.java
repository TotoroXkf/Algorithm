import org.junit.Test;

import java.util.List;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        int[] array = new int[]{1, 1, 2, 2, 7, 7, 8, 8, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3};
        List<Integer> list = solution.majorityElement(array);
        assert list.contains(3);
        assert list.contains(9);
    }

    @Test
    public void check1() {

    }

    @Test
    public void check2() {

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