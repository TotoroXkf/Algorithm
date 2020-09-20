class Solution {
    /**
     * 算是比较直接的算法问题了，没什么难度，按照题目的描述走下来就可以
     * 算是看编码的硬功夫咋样
     */
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                if (Integer.parseInt(nums2[j]) > 0) {
                    return -1;
                }
                j++;
                continue;
            } else if (j >= nums2.length) {
                if (Integer.parseInt(nums1[i]) > 0) {
                    return 1;
                }
                i++;
                continue;
            }
            int num1 = Integer.parseInt(nums1[i]);
            int num2 = Integer.parseInt(nums2[j]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}