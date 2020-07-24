package main;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public void sortStackByStack(LinkedList<Integer> stack) {
        LinkedList<Integer> help = new LinkedList<>();
        while (!stack.isEmpty()) {
            int currentValue = stack.pop();
            while (!help.isEmpty() && help.peek() < currentValue) {
                stack.push(help.pop());
            }
            help.push(currentValue);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}