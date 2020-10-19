import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, trie.root, mark, hashSet);
            }
        }
        return new ArrayList<>(hashSet);
    }

    private void search(char[][] board, int row, int column, TrieNode node, boolean[][] mark, HashSet<String> hashSet) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || mark[row][column] || node.nodes.get(board[row][column]) == null) {
            return;
        }
        TrieNode nextNode = node.nodes.get(board[row][column]);
        mark[row][column] = true;
        if (nextNode.endWord != null) {
            hashSet.add(nextNode.endWord);
        }
        if (nextNode.nodes.size() == 0) {
            node.nodes.remove(board[row][column]);
        }
        search(board, row + 1, column, nextNode, mark, hashSet);
        if (nextNode.nodes.size() == 0) {
            node.nodes.remove(board[row][column]);
        }
        search(board, row - 1, column, nextNode, mark, hashSet);
        if (nextNode.nodes.size() == 0) {
            node.nodes.remove(board[row][column]);
        }
        search(board, row, column + 1, nextNode, mark, hashSet);
        if (nextNode.nodes.size() == 0) {
            node.nodes.remove(board[row][column]);
        }
        search(board, row, column - 1, nextNode, mark, hashSet);
        if (nextNode.nodes.size() == 0) {
            node.nodes.remove(board[row][column]);
        }
        mark[row][column] = false;
    }
}

class Trie {
    public final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.nodes.get(ch) == null) {
                node.nodes.put(ch, new TrieNode());
            }
            node = node.nodes.get(ch);
        }
        node.endWord = word;
    }
}

class TrieNode {
    public final HashMap<Character, TrieNode> nodes = new HashMap<>();
    public String endWord;
}