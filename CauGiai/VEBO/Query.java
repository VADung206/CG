import java.util.Scanner;

class Query {
    private int[] tree;
    private int[] arr;
    private int size;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.tree = new int[4 * size];
        build(1, 0, size - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }

    public int query(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftValue = query(2 * node, start, mid, left, right);
        int rightValue = query(2 * node + 1, mid + 1, end, left, right);
        return Math.max(leftValue, rightValue);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        SegmentTree segmentTree = new SegmentTree(arr);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int maxInRange = segmentTree.query(1, 0, n - 1, l - 1, r - 1);
            System.out.println(maxInRange);
        }
    }
}