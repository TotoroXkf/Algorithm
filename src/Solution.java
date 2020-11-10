import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        LinkedList<Integer> numberStack = new LinkedList<>();
        LinkedList<Character> operatorStack = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index++;
                continue;
            }
            if (!Character.isDigit(s.charAt(index))) {
                int level = getLevel(s.charAt(index));
                while (!operatorStack.isEmpty() && level <= getLevel(operatorStack.peek())) {
                    compute(numberStack, operatorStack);
                }
                operatorStack.push(s.charAt(index++));
                continue;
            }
            int start = index;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                index++;
            }
            numberStack.push(Integer.parseInt(s.substring(start, index)));
        }
        while (!operatorStack.isEmpty()) {
            compute(numberStack, operatorStack);
        }
        return numberStack.pop();
    }

    private void compute(LinkedList<Integer> numberStack, LinkedList<Character> operatorStack) {
        char operator = operatorStack.pop();
        int number1 = numberStack.pop();
        int number2 = numberStack.pop();
        switch (operator) {
            case '+':
                numberStack.push(number1 + number2);
                break;
            case '-':
                numberStack.push(number2 - number1);
                break;
            case '*':
                numberStack.push(number1 * number2);
                break;
            case '/':
                numberStack.push(number2 / number1);
                break;
            default:
        }
    }

    private int getLevel(char operator) {
        switch (operator) {
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}