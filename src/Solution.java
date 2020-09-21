import java.util.Arrays;

class Solution {
    /**
     * 使用分桶的思想解决的问题，算是很巧妙的算法问题了
     * 将所有数字分到 k 个桶当中
     * 按照数学上面的分析，最大的间距一定存在桶与桶之间，而不可能存在桶的内部
     * 所以算法就是分桶，然后遍历桶，桶之间做差，求出最大值
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 求桶之间的间距
        int bucketGap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        // 没有间距说明全都相同，直接返回0
        if (bucketGap == 0) {
            return 0;
        }
        // 计算桶的个数。其实从数学上来说桶的个数就是数组长度-1，但是计算机计算的问题，所以这里计算完+1保证桶是足够的
        int bucketNum = (max - min) / bucketGap + 1;
        // 记录每个桶的最大值的数组
        int[] bucketMax = new int[bucketNum];
        // 记录每个桶的最小值的数组
        int[] bucketMin = new int[bucketNum];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        // 更新每个桶的最大最小值
        for (int num : nums) {
            int index = (num - min) / bucketGap;
            bucketMax[index] = Math.max(bucketMax[index], num);
            bucketMin[index] = Math.min(bucketMin[index], num);
        }
        int result = bucketGap;
        int lastMax = min;
        for (int i = 0; i < bucketNum; i++) {
            // 这种情况说明桶里面没东西，这个桶跳过
            if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            // 更新最大值，当前桶的最小值减去上一个桶的最大值。可能是跨过多个桶的
            result = Math.max(bucketMin[i] - lastMax, result);
            // 更新上一个桶的最大值
            lastMax = bucketMax[i];
        }
        return result;
    }
}