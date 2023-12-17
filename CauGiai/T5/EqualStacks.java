import java.util.*;

public class Main {

    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> stack1 = createStack(h1);
        Stack<Integer> stack2 = createStack(h2);
        Stack<Integer> stack3 = createStack(h3);

        int sum1 = getSum(stack1);
        int sum2 = getSum(stack2);
        int sum3 = getSum(stack3);

        while (!(sum1 == sum2 && sum2 == sum3)) {
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stack1.pop();
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stack2.pop();
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= stack3.pop();
            }
        }

        return sum1;
    }

    private static Stack<Integer> createStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        return stack;
    }

    private static int getSum(Stack<Integer> stack) {
        int sum = 0;
        for (int height : stack) {
            sum += height;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        scanner.nextLine();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        String[] h1Items = scanner.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            h1[i] = Integer.parseInt(h1Items[i]);
        }

        String[] h2Items = scanner.nextLine().split(" ");
        for (int i = 0; i < n2; i++) {
            h2[i] = Integer.parseInt(h2Items[i]);
        }

        String[] h3Items = scanner.nextLine().split(" ");
        for (int i = 0; i < n3; i++) {
            h3[i] = Integer.parseInt(h3Items[i]);
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);

        scanner.close();
    }
}