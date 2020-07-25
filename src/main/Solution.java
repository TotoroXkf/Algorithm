package main;

public class Solution {
    /**
     * 使用递归求解
     *
     * @param num   汉诺塔的层数，从上往下递增
     * @param left  左边塔的名字
     * @param mid   中间塔的名字
     * @param right 右边塔的名字
     * @return 总共需要的步数
     */
    public int hanoiProblem(int num, String left, String mid, String right) {
        if (num < 1) {
            System.out.println("It will move 0 steps");
            return 0;
        }
        int result = process(num, left, mid, right, left, right);
        System.out.println("It will move " + result + " steps");
        return result;
    }

    /**
     * 递归过程
     *
     * @param num   汉诺塔的层数，从上往下递增
     * @param left  左边塔的名字
     * @param mid   中间塔的名字
     * @param right 右边塔的名字
     * @param from  出发塔的名字
     * @param to    去往塔的名字
     * @return 所需要的步数
     */
    public int process(int num, String left, String mid, String right, String from, String to) {
        // 分为两个部分。如果num为1，表示的是最上层的移动，是可以直接写出结果的。
        // 这里就是递归的出口了
        if (num == 1) {
            // 再分为两个部分，是不是和中间有关系
            if (from.equals(mid) || to.equals(mid)) {
                // 和中间有关系的话直接就是1步到达。从中间到两边或者从两边到中间都是1步
                System.out.println("move 1 from " + from + " to" + to);
                return 1;
            } else {
                // 从左到右或者从右到做都是固定的两步
                System.out.println("move 1 from " + from + " to" + mid);
                System.out.println("move 1 from " + mid + " to" + to);
                return 2;
            }
        }

        // 如果是移动第N层
        // 和之前的逻辑一样，区分是不是和中间有关系
        if (from.equals(mid) || to.equals(mid)) {
            // 从中间到两边或者从两边到中间的过程是一样的，需要先找到不用的第三边
            String another = left;
            if (from.equals(left) || to.equals(left)) {
                another = right;
            }
            // 1. 是把上面的n-1移动到不用的第三边
            int part1 = process(num - 1, left, mid, right, from, another);
            // 2. 把n层移动到中间
            int part2 = 1;
            System.out.println("move " + num + " from " + from + " to" + mid);
            // 3. 把第三边的n-1层移动回来
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            // 从左边到右边需要5步
            // 1. 把n-1层移动到另外一边
            int part1 = process(num - 1, left, mid, right, from, to);
            // 2. 把n层移动到中间
            int part2 = 1;
            System.out.println("move " + num + " from " + from + " to" + mid);
            // 3. 把之前的n-1层用另外一边移回到开始的地方
            int part3 = process(num - 1, left, mid, right, to, from);
            // 4. 把中间的n层移动到右边
            int part4 = 1;
            System.out.println("move " + num + " from " + mid + " to" + to);
            // 5. 把之前的n-1层移动到另外一边
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}