class Solution {
    public boolean isScramble(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        return check(str1, 0, str1.length, str2, 0, str2.length);
    }

    private boolean check(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        // 只有一个字符，直接比较
        if (end1 - start1 == 1) {
            return str1[start1] == str2[start2];
        }
        // 比较字符串的构成，可以排除大量的无效运算
        if (!match(str1, str2, start1, start2, end1 - start1)) {
            return false;
        }
        // 模拟分割的过程。从i位置切割开
        for (int i = 1; i < end1 - start1; i++) {
            // 第一个字符串的左边和第二字符串的左边比较
            boolean checkResult = check(str1, start1, start1 + i, str2, start2, start2 + i);
            if (checkResult) {
                // 比较成功，再比右边
                checkResult = check(str1, start1 + i, end1, str2, start2 + i, end2);
                if (checkResult) {
                    return true;
                }
            }
            // 第一个字符串的左边和第二字符串的右边比较
            checkResult = check(str1, start1, start1 + i, str2, end2 - i, end2);
            if (checkResult) {
                // 第一个字符串的右边和第二字符串的左边比较
                checkResult = check(str1, start1 + i, end1, str2, start2, end2 - i);
                if (checkResult) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 比较字符串的构成是不是一样
     */
    private boolean match(char[] str1, char[] str2, int start1, int start2, int len) {
        int[] map = new int[26];
        for (int i = 0; i < len; i++) {
            map[str1[start1 + i] - 'a']++;
            map[str2[start2 + i] - 'a']--;
        }
        for (int value : map) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}