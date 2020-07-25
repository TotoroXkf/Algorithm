package main;

import java.util.LinkedList;

public class Solution {
    /**
     * 使用双端队列可以减少时间的损耗，属于用空间换时间的做法
     * 核心的思想是用双端队列来记录每个区域的值的情况，当窗口向后滑动的时候可以直接得到结果
     * 使用队列保存值，使得队列保持降序。新的元素入队时直接挤掉队列中小于它的值
     * 移动窗口时动态记录当前窗口的值，以及删除队头的元素保证窗口的合法性
     */
    public int[] getMaxWindow(int[] arr, int w) {
        // 异常情况直接返回
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 如果当前队列为空，或者当前值小于队尾元素，将当前的坐标放入到队尾
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
                queue.pollLast();
            }
            // 新的坐标入队
            queue.addLast(i);
            // 判读当前的队头元素是不是落在窗口外面了。如果是的话直接删除掉
            if (queue.peekFirst() == i - w) {
                queue.pollFirst();
            }
            // 记录窗口的最大值
            if (i >= w - 1) {
                res[index++] = arr[queue.peekFirst()];
            }
        }
        return res;
    }
}