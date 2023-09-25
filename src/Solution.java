class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }

    private int findKthLargest(int[] nums, int k, int start, int len) {
        int[] adjustResult = adjust(nums, start, len, nums[start]);
        int lessEnd = adjustResult[0];
        int greaterStart = adjustResult[1];
        int greaterNum = start + len - greaterStart;
        int lessNum = lessEnd - start;
        if (greaterNum >= k) {
            return findKthLargest(nums, k, greaterStart, start + len - greaterStart);
        } else if (k > len - lessNum) {
            return findKthLargest(nums, k - (len - lessNum), start, lessEnd - start);
        } else {
            return nums[lessEnd];
        }
    }

    private int[] adjust(int[] nums, int start, int len, int target) {
        int lessEnd = start;
        int greaterStart = start + len;
        int index = start;
        while (index < greaterStart) {
            if (nums[index] == target) {
                index++;
            } else if (nums[index] > target) {
                greaterStart--;
                swap(nums, index, greaterStart);
            } else {
                swap(nums, index, lessEnd);
                lessEnd++;
                index++;
            }
        }
        return new int[]{lessEnd, greaterStart};
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}