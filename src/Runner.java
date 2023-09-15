package src;

public class Runner {
    private Solution solution = new Solution();

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
    }
}
