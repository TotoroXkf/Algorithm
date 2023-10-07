import java.util.ArrayList;
import java.util.List;

class Solution {
    private Trie rootTrie = new Trie();
    private List<String> result = new ArrayList<>();
    private boolean[][] record;

    public List<String> findWords(char[][] board, String[] words) {
        record = new boolean[board.length][board[0].length];
        for (String word : words) {
            rootTrie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, rootTrie);
            }
        }
        return result.stream().toList();
    }

    private void dfs(char[][] board, int row, int column, Trie trie) {
        if (row < 0 || row >= board.length) {
            return;
        }
        if (column < 0 || column >= board[0].length) {
            return;
        }
        if (record[row][column]) {
            return;
        }
        Trie findTrie = trie.getSubTrie(board[row][column]);
        if (findTrie == null) {
            return;
        }
        record[row][column] = true;
        if (findTrie.isEnd()) {
            result.add(findTrie.getWord());
            rootTrie.delete(findTrie.getWord());
        }
        dfs(board, row, column + 1, findTrie);
        dfs(board, row, column - 1, findTrie);
        dfs(board, row + 1, column, findTrie);
        dfs(board, row - 1, column, findTrie);
        record[row][column] = false;
    }

//    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("oa");
//        trie.insert("oaa");
//        trie.delete("oa");
//    }
}

class Trie {
    private String word = "";
    private final Trie[] children = new Trie[26];
    private boolean isEnd = false;

    public void insert(String word) {
        insertInternal(this, word, 0);
    }

    private void insertInternal(Trie trie, String word, int index) {
        if (index >= word.length()) {
            trie.word = word;
            trie.isEnd = true;
            return;
        }
        int position = word.charAt(index) - 'a';
        if (trie.children[position] == null) {
            trie.children[position] = new Trie();
        }
        insertInternal(trie.children[position], word, index + 1);
    }

    public Trie getSubTrie(char ch) {
        return children[ch - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void delete(String word) {
        deleteInternal(this, word, 0);
    }

    private boolean deleteInternal(Trie trie, String word, int index) {
        if (trie == null) {
            return true;
        }
        if (index == word.length()) {
            trie.word = "";
            trie.isEnd = false;
            return isNoChildren(trie);
        }
        boolean deleteResult = deleteInternal(trie.children[word.charAt(index) - 'a'], word, index + 1);
        if (deleteResult) {
            trie.children[word.charAt(index) - 'a'] = null;
            return isNoChildren(trie);
        }
        return false;
    }

    private boolean isNoChildren(Trie trie) {
        for (Trie child : trie.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public String getWord() {
        return word;
    }
}