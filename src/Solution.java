class Solution {
    /**
     * 通用的解法是递归形式的dfs，一次求解一个index，当前index的值只和左边的和右边的值有关，继续dfs，直到返回
     * 还可以进一步优化为一个 case by case 的做法
     * 一次遍历，比较当前位置和右边节点，根据大小计算出当前节点的解
     * 再倒着遍历一次，如果左边的值大于当前值，更新当前位置的解。此时从左边和右边的解中取一个大的即可
     */
    public int candy(int[] rating) {
        int[] record = new int[rating.length];
        for (int j = 0; j < rating.length - 1; j++) {
            if (rating[j] < rating[j + 1]) {
                record[j + 1] = record[j] + 1;
            }
        }
        for (int k = rating.length - 1; k > 0; --k) {
            if (rating[k - 1] > rating[k]) {
                record[k - 1] = Math.max((record[k] + 1), record[k - 1]);
            }
        }
        int result = 0;
        for (int value : record) {
            result += value;
        }
        result += rating.length;
        return result;
    }

    /**
     * 一般形式的dfs解法
     */
    public int candy2(int[] ratings) {
        int[] record = new int[ratings.length];
        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            compute(ratings, record, i);
            result += record[i];
        }
        return result;
    }

    private void compute(int[] ratings, int[] record, int index) {
        if (index < 0 || index > ratings.length - 1) {
            return;
        }
        if (record[index] != 0) {
            return;
        }
        int leftResult = -1;
        if (index - 1 > -1 && ratings[index] > ratings[index - 1]) {
            compute(ratings, record, index - 1);
            leftResult = record[index - 1];
        }
        int rightResult = -1;
        if (index + 1 < ratings.length && ratings[index] > ratings[index + 1]) {
            compute(ratings, record, index + 1);
            rightResult = record[index + 1];
        }
        if (leftResult == -1 && rightResult == -1) {
            record[index] = 1;
        } else if (leftResult == -1) {
            record[index] = rightResult + 1;
        } else if (rightResult == -1) {
            record[index] = leftResult + 1;
        } else {
            record[index] = Math.max(leftResult, rightResult) + 1;
        }
    }

}