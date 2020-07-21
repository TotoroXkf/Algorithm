package main;

import java.util.LinkedList;

public class Solution {
    // 分别使用压入栈和弹出栈
    private LinkedList<Integer> stackPush = new LinkedList<>();
    private LinkedList<Integer> stackPop = new LinkedList<>();

    /**
     * 往队尾插入数据时，压入栈正常入栈
     * 此时如果弹出栈是空的，则将压入栈的值逐步弹出到弹出栈，则实现了队列的效果
     * 如果弹出栈不为空，则说明当前的弹出栈可以满足队列的需求，则不处理
     */
    public void add(int newNum) {
        stackPush.push(newNum);
        pushToPop();
    }

    /**
     * 移除队头的逻辑比较类似。
     * 先看能不能把压入栈的值放到弹出栈里面
     * 之后弹出栈顶就是队头了。pop即可
     */
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    /**
     * 查看对头和移除队头的逻辑完全一样
     */
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    /**
     * 把压入栈的数据放入弹出栈
     * 1. 如果 stackPush 要往 stackPop 中压入数据，那么必须一次性把 stackPush 中的数据全部压入。
     * 2. 如果 stackPop 不为空， stackPush 绝对不能向 stackPop 中压入数据。
     */
    private void pushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}