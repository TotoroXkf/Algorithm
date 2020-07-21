package main;

import java.util.LinkedList;

public class Solution {
    // 使用双栈实现
    private LinkedList<Integer> stackData = new LinkedList<>();
    private LinkedList<Integer> stackMin = new LinkedList<>();

    /**
     * push的时候，数据栈正常push，最小值栈则是比较当前栈顶的值和新值
     * 栈顶值小于等于新值则压入
     */
    public void push(int newNum) {
        if (stackMin.isEmpty() || newNum <= getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    /**
     * pop的时候，数据栈正常pop
     * 如果数据栈弹出值和最小值栈相同，则弹出最小值栈
     */
    public int pop() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = stackData.pop();
        if (value == getMin()) {
            stackMin.pop();
        }
        return value;
    }

    /**
     * 获取当前最小值，直接查询最小值栈即可
     */
    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }
}