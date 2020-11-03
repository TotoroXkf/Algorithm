import java.util.HashMap;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> hashMap = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w);
            if (hashMap.containsKey(id)) {
                return true;
            }
            if (hashMap.containsKey(id - 1) && (long) nums[i] - hashMap.get(id - 1) <= t) {
                return true;
            }
            if (hashMap.containsKey(id + 1) && hashMap.get(id + 1) - (long) nums[i] <= t) {
                return true;
            }
            hashMap.put(id, (long) nums[i]);
            if (hashMap.size() > k) {
                hashMap.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private long getId(long x, long w) {
        return x < 0 ? ((x + 1) / w) - 1 : x / w;
    }
}