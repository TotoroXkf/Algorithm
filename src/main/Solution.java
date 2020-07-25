package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /**
     * 单调栈结构。面试中经常会出现的一个问题
     * 单调栈的核心思想
     * 如果找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i]小的位置，那么需要让 stack 从栈顶到栈底的位置所代表的值是严格递减的；
     * 如果找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i]大的位置，那么需要让 stack 从栈顶到栈底的位置所代表的值是严格递增的。
     */
    public int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        // 这里栈装的是list是因为考虑到重复值，让所有的重复值放到一个list里面可以更加高效的处理
        LinkedList<List<Integer>> stack = new LinkedList<>();
        // 开始循环
        for (int i = 0; i < arr.length; i++) {
            // 当前遍历到了一个值，栈顶元素大于他，无法维持顺序，需要逐步弹出
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> list = stack.pop();
                // 找到最左边的小于它元素的下标。其实就是弹出栈顶之后的新栈顶。因为从上到下的递减的，下面的元素一定小于弹出栈顶的值
                // 如果栈空了，说明这个位置左边是没有比它小的，记为-1
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                // 整理结果
                for (Integer index : list) {
                    res[index][0] = leftLessIndex;
                    // 右边第一个小于自己的下标其实就是遍历到的当前这个位置。正是因为自己比它大才会弹出来处理
                    res[index][1] = i;
                }
            }
            // 重复值放到一起
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                // 不是重复值包装成list放进去就可以了
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        // 处理栈内剩下的元素
        // 和之前的处理方式是一样的，只不过是右边不在有比当前位置小的元素的下标了
        while (!stack.isEmpty()) {
            List<Integer> list = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer index : list) {
                res[index][0] = leftLessIndex;
                res[index][1] = -1;
            }
        }
        return res;
    }
}