import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, (str1, str2) -> {
            String num1 = str1 + str2;
            String num2 = str2 + str1;
            return num2.compareTo(num1);
        });
        if (numStrings[0].equals("0")) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String numString : numStrings) {
            stringBuilder.append(numString);
        }
        return stringBuilder.toString();
    }
}