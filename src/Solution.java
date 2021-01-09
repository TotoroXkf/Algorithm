class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int flag = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[flag++] = nums[index];
                if (index >= flag) {
                    nums[index] = 0;
                }
            }
            index++;
        }
    }
}