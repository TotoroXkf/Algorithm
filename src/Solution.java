import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = 10;
        if (s.length() < len) {
            return new ArrayList<>();
        }
        int base = 4;
        int factorial = (int) Math.pow(base, len);
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 0);
        hashMap.put('C', 1);
        hashMap.put('G', 2);
        hashMap.put('T', 3);
        int[] num = new int[s.length()];
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            num[i] = hashMap.get(s.charAt(i));
        }
        for (int i = 0; i < len; i++) {
            value = value * base + num[i];
        }
        HashSet<Integer> repeatSet = new HashSet<>();
        repeatSet.add(value);
        HashSet<String> resultSet = new HashSet<>();
        int start = 0;
        for (int i = len; i < s.length(); i++, start++) {
            value = value * base + num[i] - num[start] * factorial;
            if (!repeatSet.add(value)) {
                resultSet.add(s.substring(i + 1 - len, i + 1));
            }
        }
        return new ArrayList<>(resultSet);
    }
}