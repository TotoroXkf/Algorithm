import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 递归法的应用
     * 抽象的来看这个问题就是先判断从start到i位置的字符串是不是回文字符串，是的话递归后面的字符串，然后从这个位置继续向后找新的回文字符串
     * 具体的逻辑看代码即可
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        }
        partition(s, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * 主要的处理过程
     */
    public void partition(String s, int start, List<List<String>> result, List<String> currentList) {
        // 完成遍历，直接添加结果
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // 判断开始到当前位置的字符串是不是回文字符串
            // 不是回文字符串的话直接跳过，到一下个位置
            if (!isPalindrome(s, start, i + 1)) {
                continue;
            }
            // 是回文字符串，将当前字符串记录下来
            currentList.add(s.substring(start, i + 1));
            // 递归处理后续的字符串
            partition(s, i + 1, result, currentList);
            // 当前字符串处理完毕之后移除，往后找新的字符串
            currentList.remove(currentList.size() - 1);
        }
    }

    /**
     * 判断一个字符串是不是回文字符串
     */
    public boolean isPalindrome(String s, int left, int right) {
        int i = left;
        int j = right - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}