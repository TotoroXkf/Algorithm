class Solution {

}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node.putNode(ch, new TrieNode());
            node = node.getNode(ch);
        }
        node.setEnd(true);
        System.out.println();
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = findNode(prefix);
        return node != null;
    }

    private TrieNode findNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length() && node != null; i++) {
            char ch = word.charAt(i);
            node = node.getNode(ch);
        }
        return node;
    }
}

class TrieNode {
    private final TrieNode[] links = new TrieNode[26];
    private boolean isEnd;

    public void putNode(char ch, TrieNode node) {
        if (links[ch - 'a'] != null) {
            return;
        }
        links[ch - 'a'] = node;
    }

    public TrieNode getNode(char ch) {
        return links[ch - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}