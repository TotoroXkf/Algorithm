class Solution {
    /**
     * 位运算很多时候确实很难说清楚为什么
     * 这个题的思路就是，异或操作一次或者3次都会得到数字本身
     * 那就要区分出3次的情况
     * 所以设置两个变量 出现一次的标志变量和出现两次的标志变量
     * 这样两个变量的效果就是
     * 当数字只出现一次的时候 出现一次的标志变量就是这个数字本身
     * 当数字只出现三次的时候 出现一次的标志变量和出现两次的标志变量都是0
     * 但是推到过程实在很难说清楚。。。。
     */
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }
}