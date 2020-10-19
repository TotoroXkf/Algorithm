import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void check() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        assert wordDictionary.search(".");
        assert wordDictionary.search("a");
        assert !wordDictionary.search("aa");
        assert wordDictionary.search("a");
        assert !wordDictionary.search(".a");
        assert !wordDictionary.search("a.");
    }

    @Test
    public void check1() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        assert !wordDictionary.search("pad");
        assert wordDictionary.search("bad");
        assert wordDictionary.search(".ad");
        assert wordDictionary.search("b..");
    }

    @Test
    public void check2() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("bat");
        assert !wordDictionary.search("a");
        assert wordDictionary.search(".at");
        assert wordDictionary.search(".at");
        assert wordDictionary.search("an.");
        assert !wordDictionary.search("a.d.");
        assert !wordDictionary.search("b.");
        assert wordDictionary.search("a.d");
        assert !wordDictionary.search(".");
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