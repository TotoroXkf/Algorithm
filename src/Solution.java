class Solution {
    /**
     * 数组预处理的问题
     * 首先需要计算出每个位置的消耗值gas[i] - cost[i]
     * 记录到一个数组里面，同时求和，和小于0直接返回-1
     * 遍历新生成的数组
     * 当找到1个正数的时候向后遍历看能不能走到尾，也就是不断地要求叠加大于0
     * 能的话返回这个正数的下标
     * 不能的话从中断位置的下一个继续即可
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gains = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            gains[i] = gas[i] - cost[i];
            sum += gains[i];
        }
        if (sum < 0) {
            return -1;
        }
        sum = 0;
        int i = 0;
        while (i < gains.length) {
            sum += gains[i];
            if (sum < 0) {
                sum = 0;
                i++;
                continue;
            }
            int j = i + 1;
            while (sum >= 0 && j < gains.length) {
                sum += gains[j];
                j++;
            }
            if (j == gains.length) {
                return i;
            }
            sum = 0;
            i = j;
        }
        return -1;
    }
}