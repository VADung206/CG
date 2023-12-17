import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        List<int[]> pairs = closestNumbers(arr);
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

    public static List<int[]> closestNumbers(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(new int[]{arr[i], arr[i+1]});
            } else if (diff == minDiff) {
                result.add(new int[]{arr[i], arr[i+1]});
            }
        }

        return result;
    }
}