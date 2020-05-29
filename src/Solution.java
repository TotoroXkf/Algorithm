import java.util.ArrayList;
    import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int step = 1;


        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j > -1; j--) {
                result.add(step + result.get(j));
            }
            step <<= 1;
        }
        return result;
    }
}