import java.util.HashMap;

class Solution {
    /**
     * 算是个数学问题把。。。。。
     * 具体的解法看笔记上的题解图吧
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        // 出现负数，记录负号
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            result.append("-");
        }
        // 使用正数来计算结果
        long above = Math.abs((long) numerator);
        long below = Math.abs((long) denominator);
        long value = above % below;
        // 可以直接整除的情况直接返回
        if (value == 0) {
            return result.append(above / below).toString();
        }
        HashMap<Long, Integer> hashMap = new HashMap<>();
        // 首位
        result.append(Math.abs((long) numerator) / Math.abs((long) denominator));
        result.append(".");
        while (value != 0) {
            // 关键的算法，把余数*10
            value *= 10;
            // 如果出现过，说明会出现循环小数，在出现的位置叠加（）
            if (hashMap.containsKey(value)) {
                int index = hashMap.get(value);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            // 记录出现过的余数
            hashMap.put(value, result.length());
            // 当前位的数字
            result.append(value / below);
            // 计算下一个位置的值
            value %= below;
        }
        return result.toString();
    }
}