package recursion_lab12;

import java.util.Stack;

/**
 * A utility class for evaluating simple mathematical expressions using recursive parsing.
 * Supports operations: addition, subtraction, multiplication, and division.
 * Handles operator precedence and floating-point numbers.
 */
public class RecursiveExpressionParser {
    /**
     * Evaluates a mathematical expression represented as a string.
     *
     * @param expression The expression to be evaluated (e.g., "3 + 5 * 2")
     * @return The result of the expression
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static double evaluateExpression(String expression) {
        // Trim and remove leading/trailing whitespace
        expression = expression.trim();

        // Base case: single number
        if (isNumber(expression)) {
            return Double.parseDouble(expression);
        }

        // Recursive case: split expression and evaluate sub-expressions
        int index = findNextOperator(expression);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }

        double left = evaluateExpression(expression.substring(0, index).trim());
        double right = evaluateExpression(expression.substring(index + 1).trim());
        char operator = expression.charAt(index);

        return performOperation(left, right, operator);
    }

    /**
     * Performs the specified mathematical operation on two operands.
     *
     * @param left     The left operand
     * @param right    The right operand
     * @param operator The mathematical operator (+, -, *, /)
     * @return The result of the operation
     * @throws IllegalArgumentException if the operator is invalid
     */
    private static double performOperation(double left, double right, char operator) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                if (right == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return left / right;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * Finds the index of the next operator in the expression.
     * Respects operator precedence (multiplication/division first, addition/subtraction second).
     *
     * @param expression The expression to search
     * @return The index of the next operator, or -1 if no operator is found
     */
    private static int findNextOperator(String expression) {
        Stack<Character> stack = new Stack<>();
        int minIndex = -1;
        int minPrecedence = Integer.MAX_VALUE;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (isOperator(c)) {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(c)) {
                    char topOperator = stack.pop();
                    int topIndex = expression.indexOf(topOperator, i - 1);
                    if (topIndex < minIndex || minIndex == -1) {
                        minIndex = topIndex;
                        minPrecedence = getPrecedence(topOperator);
                    }
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            char topOperator = stack.pop();
            int topIndex = expression.indexOf(topOperator);
            if (topIndex < minIndex || minIndex == -1) {
                minIndex = topIndex;
                minPrecedence = getPrecedence(topOperator);
            }
        }

        return minIndex;
    }

    /**
     * Checks if the given character is a valid operator.
     *
     * @param c The character to check
     * @return True if the character is a valid operator, false otherwise
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Checks if the given string represents a valid number.
     *
     * @param str The string to check
     * @return True if the string represents a valid number, false otherwise
     */
    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Gets the precedence of a given operator.
     * Multiplication and division have higher precedence than addition and subtraction.
     *
     * @param operator The operator to get the precedence for
     * @return The precedence of the operator
     */
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}