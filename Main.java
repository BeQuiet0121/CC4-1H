import java.util.Stack;
import java.util.Scanner;

public class Main {

    // Method to check if the character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%'; 
    }

    // Method to get the precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2; // Adjusted precedence for modulo
            default:
                return 0;
        }
    }

    // Method to convert infix to postfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue; // Ignore whitespace
            }
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove '(' from stack
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfix.append(top);
        }

        return postfix.toString();
    }

    // Method to convert postfix to prefix
    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = c + operand1 + operand2;
                stack.push(expression);
            }
        }

        return stack.pop();
    }

    // Method to convert infix to prefix
    public static String infixToPrefix(String infix) {
        String postfix = infixToPostfix(infix);
        return postfixToPrefix(postfix);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix: ");
        String infix = scanner.nextLine();

        try {
            String postfix = infixToPostfix(infix);
            String prefix = infixToPrefix(infix);

            System.out.println("Prefix is: " + prefix);
            System.out.println("Postfix is: " + postfix);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}