class Solution {
    /**
     * 这个题的关键在于看到背后的二分本质
     * 拿到题目之后向判断左右两个边界点是不是满足，满足直接返回
     * 然后二分中间。如果中间点满足直接返回
     * 不满足时存在以下情况
     * 中间值小于左边相邻节点值
     * 中间值大于左边相邻节点值
     * 根据题目，相邻节点值不可能相同
     * 分开讨论。现在的前提条件时nums[1]>nums[0]
     * <p>
     * 当中间值小于左边相邻节点值时
     * 这说明，从0节点向右是上升趋势，而从mid向mid-1是下降趋势
     * 那么，从0到mid一定会经历一个先升后降的趋势。所以，在0到mid中间存在解。二分左边
     * <p>
     * 当中间值大于左边相邻节点值时
     * 和上面的一样，存在从len-1到len-2是上升趋势
     * 从mid先mid+1必然也是上升趋势，不然直接就返回mid了
     * 所以右边势必存在先升后降的趋势。存在解，二分右边
     */
    public int findPeakElement(int[] nums) {
        if (nums.length < 2 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == left || mid == right) {
                break;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid - 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return 0;
    }
}