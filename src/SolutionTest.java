import org.junit.Test;

import java.util.List;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        char[][] board = new char[][]{
            new char[]{'o', 'a', 'a', 'n'},
            new char[]{'e', 't', 'a', 'e'},
            new char[]{'i', 'h', 'k', 'r'},
            new char[]{'i', 'f', 'l', 'v'}
        };
        List<String> result = solution.findWords(board, words);
        assert result.contains("eat");
        assert result.contains("oath");
    }

    @Test
    public void check1() {
        String[] words = new String[]{"aa"};
        char[][] board = new char[][]{
            new char[]{'a', 'a'},
        };
        List<String> result = solution.findWords(board, words);
        assert result.contains("aa");
    }

    @Test
    public void check2() {
        String[] words = new String[]{"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"};
        char[][] board = new char[][]{new char[]{'a', 'b'}, new char[]{'c', 'd'}};
        List<String> result = solution.findWords(board, words);
        assert result.contains("ab");
        assert result.contains("ac");
        assert result.contains("bd");
        assert result.contains("ca");
        assert result.contains("db");
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