class Solution {
    /**
     * 比较难以想到的一种算法，也叫投票算法
     * 首先要想明白一个事情，就是出现次数大于一半，说明存在一个现象，剩下的所有数字和这个出现最多的数字一一相消，最后这个出现最多的数字仍然会剩下至少1个
     * 所以投票算法就是利用这个思路
     * 首先指定result为随便一个值，然后当前票数为0
     * 遍历数组，如果当前票数count为0，则result为当前遍历到的数字
     * 如果当前数字与result相同，count++,反之减减
     * 循环结束，result自然就是最后的答案了
     * 可以生效的原因在于前面说的现象，下的所有数字和这个出现最多的数字一一相消，最后这个出现最多的数字仍然会剩下至少1个
     * 按照上面的做法其实保证了这个逻辑的成立。就是让数字之间相消。但是不论怎么相消，最后出现多的那个数字都会被剩下来
     */
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}