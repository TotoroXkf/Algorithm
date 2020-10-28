class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }

    public int findKthLargest(int[] nums, int k, int start, int end) {
        if (start + 1 == end) {
            return nums[start];
        }
        int target = nums[start];
        int left = start;
        int right = end - 1;
        while (left <= right) {
            if (nums[left] < target) {
                left++;
                continue;
            }
            swap(nums, left, right--);
        }
        swap(nums, left, end - 1);
        int value = end - left;
        if (value == k) {
            return nums[left];
        }
        if (value > k) {
            return findKthLargest(nums, k, left + 1, end);
        } else {
            return findKthLargest(nums, k - value, start, left);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}