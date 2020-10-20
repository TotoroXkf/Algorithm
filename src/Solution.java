class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int tempValue = dp2;
            dp2 = Math.max(dp2, nums[i] + dp1);
            dp1 = tempValue;
        }
        int result = dp2;
        dp1 = nums[1];
        dp2 = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int tempValue = dp2;
            dp2 = Math.max(dp2, nums[i] + dp1);
            dp1 = tempValue;
        }
        result = Math.max(result, dp2);
        return result;
    }
}