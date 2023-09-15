package src;

public class Trie {
    private final Trie[] children = new Trie[26];
    private boolean isEnd = false;

    public Trie() {

    }

    public void insert(String word) {
        insertInternal(this, word, 0);
    }

    private void insertInternal(Trie trie, String word, int index) {
        if (index >= word.length()) {
            trie.isEnd = true;
            return;
        }
        int position = word.charAt(index) - 'a';
        if (trie.children[position] == null) {
            trie.children[position] = new Trie();
        }
        insertInternal(trie.children[position], word, index + 1);
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(this, word, 0);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(this, prefix, 0) != null;
    }

    private Trie searchPrefix(Trie trie, String word, int index) {
        if (index == word.length()) {
            return trie;
        }
        int position = word.charAt(index) - 'a';
        if (trie.children[position] == null) {
            return null;
        }
        return searchPrefix(trie.children[position], word, index + 1);
    }
}
