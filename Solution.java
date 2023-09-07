import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private Map<Character, Character> map = new HashMap<>();
    private Set<Character> set = new HashSet<>();

    public boolean isIsomorphic(String s, String t) {
        return recursive(s, t, 0);
    }

    private boolean recursive(String s, String t, int index) {
        if (index >= s.length() || index >= t.length()) {
            return true;
        }
        if (map.containsKey(s.charAt(index))) {
            if (map.get(s.charAt(index)) == t.charAt(index)) {
                return recursive(s, t, index + 1);
            } else {
                return false;
            }
        } else {
            if (set.contains(t.charAt(index))) {
                return false;
            } else {
                set.add(t.charAt(index));
                map.put(s.charAt(index), t.charAt(index));
                return recursive(s, t, index + 1);
            }

        }
    }
}