import java.util.Arrays;

class Solution {
    /**
     * 这个题很难直接想到动态规划
     * 演变的过程大约是暴力求解->记忆搜索->动态规划
     * 所以实际问题还是要迭代优化的好
     * 思路是这样，dp[i]代表了从0到i需要切几刀
     * 那么分两个情况
     * 从0到i都是一个回文串，dp[i] = 0
     * 从中间某个位置a到i是回文串（也可能只有i自己是回文串），那么从a到i需要1到，之前需要dp[a-1]刀。所以dp[i] = dp[a-1]+1
     * 每个位置都可能被重复的计算，所以这里还需要做一个最小值的比较dp[i] = min(dp[i],dp[a-1]+1)
     * 按照这个思路就可以完成了
     */
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, s.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            // 单个字符为中心扩散
            compute(s, i, i, dp);
            // 两个字符为中心扩散
            compute(s, i, i + 1, dp);
        }
        return dp[s.length() - 1];
    }

    public void compute(String s, int left, int right, int[] dp) {
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 说明从0到right整个是个回文字符串，则当前的dp值为0
            if (left == 0) {
                dp[right] = 0;
                return;
            }
            // 从left到right整个是个回文字符串，则从i到j这段只需要切一刀，所以总和应该是 从0到left-1的解 +1
            // 就是dp[left-1]+1。同时比较出最小的。一个位置可能多次计算
            dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            left--;
            right++;
        }
    }
}