import java.math.BigDecimal;

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder current = new StringBuilder();
        StringBuilder result = new StringBuilder("0");
        largestNumber(nums, 0, current, result, new boolean[nums.length]);
        return result.toString();
    }

    private void largestNumber(int[] nums, int index, StringBuilder current, StringBuilder result, boolean[] marked) {
        if (index >= nums.length) {
            if (new BigDecimal(current.toString()).compareTo(new BigDecimal(result.toString())) > 0) {
                result.delete(0, result.length());
                result.append(current.toString());
                return;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (marked[i]) {
                continue;
            }
            String s = String.valueOf(nums[i]);
            current.append(s);
            index++;
            marked[i] = true;
            largestNumber(nums, index, current, result, marked);
            current.delete(current.length() - s.length(), current.length());
            index--;
            marked[i] = false;
        }
    }
}