package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 一个bfs的应用，算是思维的扩展
     * 按照bfs的逻辑，一次添加最相近的一层节点，逐步遍历，在添加下一层节点，直到找到
     * 当找到的时候一定是可以达到的最小距离，返回答案即可
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 把开始的单词也添加进去
        wordList.add(0, beginWord);
        // 生成图
        HashMap<String, List<String>> graph = createGraph(wordList);
        // 记录已经被遍历过的节点，防止重复遍历
        HashSet<String> hashSet = new HashSet<>();

        if (!graph.containsKey(endWord)) {
            return 0;
        }

        int result = 0;
        // 准备执行 bfs。每一次遍历一层
        LinkedList<List<String>> queue = new LinkedList<>();
        // 第一层是开始单词
        List<String> tempBegin = new ArrayList<>();
        tempBegin.add(beginWord);
        hashSet.add(beginWord);
        queue.add(tempBegin);
        // 执行bfs
        while (!queue.isEmpty()) {
            result++;
            // 当前层的所有单词
            List<String> words = queue.removeFirst();
            // 这层的遍历要得到的下一层的所有单词
            List<String> nextWords = new ArrayList<>();
            // 遍历当前层
            for (String currentWord : words) {
                // 找到了对应的单词，直接返回结果
                if (currentWord.equals(endWord)) {
                    return result;
                }
                // 添加直接相关的下一层
                for (String findWord : graph.get(currentWord)) {
                    if (hashSet.contains(findWord)) {
                        continue;
                    }
                    hashSet.add(findWord);
                    nextWords.add(findWord);
                }
            }
            // 如果下一层有节点的话添加到队列
            if (!nextWords.isEmpty()) {
                queue.add(nextWords);
            }
        }
        return 0;
    }

    /**
     * 按照word的关系生成图
     */
    private HashMap<String, List<String>> createGraph(List<String> wordList) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String word2 = wordList.get(j);
                if (isNear(word1, word2)) {
                    if (hashMap.containsKey(word1)) {
                        hashMap.get(word1).add(word2);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(word2);
                        hashMap.put(word1, list);
                    }
                    if (hashMap.containsKey(word2)) {
                        hashMap.get(word2).add(word1);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(word1);
                        hashMap.put(word2, list);
                    }
                }
            }
        }
        return hashMap;
    }

    /**
     * 判断两个单词的距离是不是1
     */
    private boolean isNear(String str1, String str2) {
        int distance = 0;
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length() && distance < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                distance++;
            }
        }
        return distance == 1;
    }
}