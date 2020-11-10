import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        String str = "3+2*2";
        assert 7 == solution.calculate(str);
    }

    @Test
    public void check1() {
        String str = "3/2";
        assert 1 == solution.calculate(str);
    }

    @Test
    public void check2() {
        String str = " 33+5 / 2 ";
        assert 35 == solution.calculate(str);
    }

    @Test
    public void check3() {
        String str = "1-1+1";
        assert 1 == solution.calculate(str);
    }

    @Test
    public void check4() {
        String str = "1-1-1";
        assert -1 == solution.calculate(str);
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