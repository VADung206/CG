import java.util.*;

class SegmentTree {
    private int[] tree;
    private int[] arr;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        int treeSize = 4 * n; // Kích thước của cây segment sẽ là 4 * số phần tử trong mảng
        tree = new int[treeSize];
        build(0, n - 1, 0);
    }

    private void build(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(start, mid, 2 * node + 1);
        build(mid + 1, end, 2 * node + 2);
        tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int query(int start, int end, int left, int right, int node) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE; // Trường hợp không giao với đoạn cần truy vấn
        }
        if (left <= start && right >= end) {
            return tree[node]; // Trường hợp đoạn câu truy vấn hoàn toàn nằm trong đoạn hiện tại
        }
        int mid = (start + end) / 2;
        int leftMin = query(start, mid, left, right, 2 * node + 1);
        int rightMin = query(mid + 1, end, left, right, 2 * node + 2);
        return Math.min(leftMin, rightMin);
    }

    public void update(int start, int end, int index, int value, int node) {
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index >= start && index <= mid) {
            update(start, mid, index, value, 2 * node + 1);
        } else {
            update(mid + 1, end, index, value, 2 * node + 2);
        }
        tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
}

public class Main {
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
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int min = segmentTree.query(0, n - 1, l - 1, r - 1, 0);
                System.out.println(min);
            } else if (queryType == 2) {
                int id = scanner.nextInt();
                int v = scanner.nextInt();
                segmentTree.update(0, n - 1, id - 1, v, 0);
            }
        }
        scanner.close();
    }
}