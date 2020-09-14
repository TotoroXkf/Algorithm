class Solution {
    /**
     * 比较好的分析类型问题
     * <p>
     * 首先讨论不存在0的情况
     * - 全部都是正数，所有数字相乘
     * - 存在偶数个负数，所有数字相乘
     * - 存在奇数个负数，从左边往右边，直到最后一个负数的累乘值和从右边往左边直到最后一个负数的累乘值的最大值是答案
     * 按照上面的情况，可以正向遍历数组，累乘所有结果。再反向遍历数组，累乘所有结果，中间不断比较最大值。这样可以覆盖上面的情况
     * <p>
     * 再看存在0的情况
     * 假设正向遍历。当遇到0时，这一段的解其实已经出来了。要么就是0，要么就是不带0的前面的累乘值
     * 所以遍历到0，和上面的处理情况一样。乘起来，比较最大值，然后从0的下一个位置开始新的遍历
     * 从0向后的情况和0之前的情况其实完全没有关系了
     */
    public int maxProduct(int[] nums) {
        int currentValue = 1;
        int result = nums[0];
        for (int num : nums) {
            currentValue *= num;
            result = Math.max(result, currentValue);
            if (num == 0) {
                currentValue = 1;
            }
        }
        currentValue = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            currentValue *= nums[i];
            result = Math.max(result, currentValue);
            if (nums[i] == 0) {
                currentValue = 1;
            }
        }
        return result;
    }
}