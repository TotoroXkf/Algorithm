class Solution {
    /**
     * 常规的解法就不说了
     * 特殊的解法是位运算
     * 异或操作
     * 相同则为0
     * 所以让数组中所有的元素异或，所有出现两次的异或都变成了0
     * 最后0异或只出现一次的数字
     * 得到只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}