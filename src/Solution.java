import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        char[] charArray = s.toCharArray();
        List<String> result = new ArrayList<>();
        restore(charArray, new ArrayList<>(), result, 1, 0);
        return result;
    }

    private void restore(char[] charArray, ArrayList<Integer> currentList, List<String> result, int area, int index) {
        if (area > 4) {
            if (index < charArray.length) {
                return;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int value : currentList) {
                    stringBuilder.append(value);
                    stringBuilder.append(".");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                result.add(stringBuilder.toString());
            }
        }
        for (int i = index; i < charArray.length && i < index + 3; i++) {
            int j = index;
            int num = charArray[index] - '0';
            j++;
            while (j <= i) {
                if (charArray[index] == '0') {
                    num = 256;
                    break;
                }
                num *= 10;
                num += (charArray[j] - '0');
                j++;
            }
            if (num > 255) {
                break;
            }
            currentList.add(num);
            restore(charArray, currentList, result, area + 1, i + 1);
            currentList.remove(currentList.size() - 1);
        }
    }
}