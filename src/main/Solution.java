package main;

import java.util.LinkedList;

public class Solution {
    /**
     * 每一次都移除栈底元素，然后递归逆序子栈，再将栈底元素压入即可完成逆序
     */
    public void reverse(LinkedList<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int value = removeAndGet(stack);
        reverse(stack);
        stack.push(value);
    }

    /**
     * 移除栈底元素并且返回
     */
    private int removeAndGet(LinkedList<Integer> stack) {
        int value = stack.pop();
        if (stack.isEmpty()) {
            return value;
        }
        int last = removeAndGet(stack);
        stack.push(last);
        return last;
    }
}