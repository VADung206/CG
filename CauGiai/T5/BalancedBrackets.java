import java.util.*;

class Solution {
    private static boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
    private static boolean isClosingBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else if (isClosingBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String result = isBalanced(s);
            System.out.println(result);
        }

        scanner.close();
    }
}