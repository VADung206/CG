import java.util.*;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int a, b, cost;

    Edge(int a, int b, int cost) {
        this.cost = cost;
        this.a = a;
        this.b = b;
    }

    public int compareTo(Edge x) {
        return Integer.compare(this.cost, x.cost);
    }
}

public class Prim {
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[n + 1];
        Arrays.fill(arr, -1);

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int nodeA = scanner.nextInt();
            int nodeB = scanner.nextInt();
            int edgeCost = scanner.nextInt();
            adj.get(nodeA).add(new Edge(nodeA, nodeB, edgeCost));
            adj.get(nodeB).add(new Edge(nodeB, nodeA, edgeCost));
        }

        int startingNode = scanner.nextInt();

        int count = 0;
        int totalWeight = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        pq.addAll(adj.get(startingNode));

        while (count < n - 1) {
            Edge currentEdge = pq.remove();
            int nodeA = currentEdge.a;
            int nodeB = currentEdge.b;

            if (findParent(nodeA) != findParent(nodeB)) {
                count++;
                totalWeight += currentEdge.cost;
                union(nodeA, nodeB);
                pq.addAll(adj.get(nodeB));
            }
        }

        System.out.println(totalWeight);
    }

    static int findParent(int node) {
        while (arr[node] != -1)
            node = arr[node];
        return node;
    }

    static void union(int nodeA, int nodeB) {
        arr[findParent(nodeB)] = findParent(nodeA);
    }
}