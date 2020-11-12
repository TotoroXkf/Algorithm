import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        int candidate1 = nums[0];
        int count1 = 0;
        int candidate2 = nums[0];
        int count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
                continue;
            }
            if (num == candidate2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
                continue;
            }
            if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
                continue;
            }
            if (count1 > 0) {
                count1--;
            }
            if (count2 > 0) {
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }
}