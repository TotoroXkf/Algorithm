class Solution {
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int[] next = getNext(s);
        int i = s.length() - 1;
        int j = 0;
        while (i > -1) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                continue;
            }
            j = next[j];
            if (j == -1) {
                i--;
                j = 0;
            }
        }
        if (j == s.length()) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s.substring(j));
        stringBuilder.reverse();
        stringBuilder.append(s);
        return stringBuilder.toString();
    }

    private int[] getNext(String p) {
        int[] result = new int[p.length()];
        char[] chars = p.toCharArray();
        result[0] = -1;
        for (int i = 0; i < chars.length - 1; i++) {
            int j = i;
            int nextIndex = result[j];
            while (nextIndex != -1) {
                if (chars[nextIndex] == chars[i]) {
                    result[i + 1] = result[j] + 1;
                    break;
                }
                j = nextIndex;
                nextIndex = result[j];
            }
        }
        return result;
    }
}