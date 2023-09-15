package src;

public class Solution {
    public int rob(int[] nums) {
        int subAnswer1 = 0;
        int subAnswer2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newAnswer = Math.max(subAnswer2, nums[i] + subAnswer1);
            subAnswer1 = subAnswer2;
            subAnswer2 = newAnswer;
        }
        return subAnswer2;
    }
}