package utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import main.Solution;

public class SolutionTest {
    private Solution solution = new Solution();
    private Case testCase = new Case();

    @Test
    public void test() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        assert solution.ladderLength(beginWord, endWord, wordList) == 5;
    }
} 
