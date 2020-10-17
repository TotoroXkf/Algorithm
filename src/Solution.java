class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int currentSum = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            currentSum += nums[right];
            while (currentSum >= s && left <= right) {
                if (result == 0) {
                    result = right - left + 1;
                } else {
                    result = Math.min(right - left + 1, result);
                }
                currentSum -= nums[left];
                left++;
            }
            right++;
        }
        return result;
    }
}