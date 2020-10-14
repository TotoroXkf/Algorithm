import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return true;
        }
        HashMap<Character, Character> hashMap = new HashMap<>();
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                if (hashMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
                continue;
            }
            if (hashSet.contains(t.charAt(i))) {
                return false;
            }
            hashMap.put(s.charAt(i), t.charAt(i));
            hashSet.add(t.charAt(i));
        }
        return true;
    }
}