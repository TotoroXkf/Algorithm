import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        Trie trie = new Trie();
        trie.insert("apple");
        assert trie.search("apple");   // 返回 true
        assert !trie.search("app");     // 返回 false
        assert trie.startsWith("app"); // 返回 true
        trie.insert("app");
        assert trie.search("app");     // 返回 true

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

    @Test
    public void check10() {

    }
}