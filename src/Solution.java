import java.util.HashSet;

public class Solution {
    /**
     * 遍历数组,当遇到一个数字的时候找他的下一位。然后跌代继续找下下位。动态记录中间的长度即可
     * 使用HashSet快速的找到下一位，降低复杂度
     * 中间还可以再度优化，当前这个数字的前一位已经有了，直接跳过当前遍历的这个数字就可以。以为前面肯定被串过了
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        // 装入HashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int currentLen;
        int currentValue;
        for (int value : hashSet) {
            // 有前一位直接跳过
            if (hashSet.contains(value - 1)) {
                continue;
            }
            // 迭代查找下一位
            currentValue = value;
            currentLen = 1;
            while (hashSet.contains(currentValue + 1)) {
                currentValue++;
                currentLen++;
            }
            // 动态记录最大值
            result = Math.max(result, currentLen);
        }
        return result;
    }
}