package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 第一道题的思路这里不再适用，相对的，这个题因为要收集中间的过程，所以改用了记忆搜索加dfs
     * 当遍历到一个位置i，就看从i到开始遍历的位置这段所形成的单词是不是再词组里面，如果再的画从这个位置的下一个继续向后递归
     * 当遍历结束，如果记录结果的list长度没有发生变化，说明当前这个位置无效，记录下来，下次遇到直接返回
     * 这样就实现了 dfs + 记忆搜索
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        wordBreak(s, 0, new StringBuilder(), hashSet, new boolean[s.length()], result);
        return result;
    }

    private void wordBreak(String s, int index, StringBuilder currentString, HashSet<String> hashSet, boolean[] mark, List<String> result) {
        if (s.isEmpty() || index > s.length() - 1) {
            result.add(currentString.substring(0, currentString.length() - 1));
            return;
        }
        if (mark[index]) {
            return;
        }
        int len = result.size();
        for (int i = index; i < s.length(); i++) {
            String subString = s.substring(index, i + 1);
            if (hashSet.contains(subString)) {
                currentString.append(subString).append(" ");
                wordBreak(s, i + 1, currentString, hashSet, mark, result);
                currentString.delete(currentString.length() - subString.length() - 1, currentString.length());
            }
        }
        if (len == result.size()) {
            mark[index] = true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
