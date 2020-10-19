class Solution {

}

class WordDictionary {
    private final Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.setEnd(true);
    }

    public Trie(TrieNode trieNode) {
        root = trieNode;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node.putNode(ch, new TrieNode());
            node = node.getNode(ch);
        }
        node.setEnd(true);
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return root.isEnd();
        }
        TrieNode node = root;
        int index = 0;
        while (index < word.length()) {
            char ch = word.charAt(index);
            if (ch == '.') {
                break;
            }
            node = node.getNode(ch);
            if (node == null) {
                return false;
            }
            index++;
        }
        if (index == word.length()) {
            return node.isEnd();
        }
        for (int i = 0; i < node.links.length; i++) {
            TrieNode subNode = node.links[i];
            if (subNode == null) {
                continue;
            }
            Trie subTrie = new Trie(subNode);
            boolean subResult = subTrie.search(word.substring(index + 1));
            if (subResult) {
                return true;
            }
        }
        return false;
    }
}

class TrieNode {
    public final TrieNode[] links = new TrieNode[26];
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