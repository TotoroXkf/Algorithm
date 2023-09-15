package src;

public class WordDictionary {
    private final WordDictionary[] children = new WordDictionary[26];
    private boolean isEnd = false;

    public WordDictionary() {

    }

    public void addWord(String word) {
        addWord(this, word, 0);
    }

    private void addWord(WordDictionary wordDictionary, String word, int index) {
        if (index == word.length()) {
            wordDictionary.isEnd = true;
            return;
        }
        int position = word.charAt(index) - 'a';
        if (wordDictionary.children[position] == null) {
            wordDictionary.children[position] = new WordDictionary();
        }
        addWord(wordDictionary.children[position], word, index + 1);
    }

    public boolean search(String word) {
        return search(this, word, 0);
    }

    private boolean search(WordDictionary wordDictionary, String word, int index) {
        if (index == word.length()) {
            return wordDictionary != null && wordDictionary.isEnd;
        }
        if (wordDictionary == null) {
            return false;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (WordDictionary child : wordDictionary.children) {
                if (child == null) {
                    continue;
                }
                boolean searchResult = search(child, word, index + 1);
                if (searchResult) {
                    return true;
                }
            }
        } else {
            return search(wordDictionary.children[ch - 'a'], word, index + 1);
        }
        return false;
    }
}
