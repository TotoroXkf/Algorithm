public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int startIndex, int endIndex) {
        int subAnswer1 = 0;
        int subAnswer2 = nums[startIndex];
        for (int i = startIndex + 1; i < endIndex + 1; i++) {
            int newAnswer = Math.max(subAnswer2, nums[i] + subAnswer1);
            subAnswer1 = subAnswer2;
            subAnswer2 = newAnswer;
        }
        return subAnswer2;
    }
}