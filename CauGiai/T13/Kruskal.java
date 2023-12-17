package Week13;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int u;
    public int v;
    public int w;

    public Edge (int v1, int v2, int weight) {
        u = v1;
        v = v2;
        w = weight;

        if(u > v) {
            int tmp = u;
            u = v;
            v = tmp;
        }
    }

    @Override
    public int compareTo(Edge o) {
        if (w < o.w) return -1;
        if (w > o.w) return 1;
        if (u < o.u) return -1;
        if (u > o.u) return 1;
        return Integer.compare(v, o.v);
    }
}
class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pp = find(p);
        int pq = find(q);
        if (pp != pq) {
            if (size[pp] > size[pq]) {
                int tmp = pp;
                pp = pq;
                pq = tmp;
            }
            parent[pq] = pp;
            size[pp] += size[pq];
        }
    }

    public int find(int p) {
        if (p == parent[p]) return p;
        return parent[p] = find(parent[p]);
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}

public class Kruskal {

    private static int kruskals(int n, Queue<Edge> pq) {
        int minMst = 0;
        UnionFind unf = new UnionFind(n);
        for (int i = 1; i < n; i++) {
            Edge min = pq.poll();
            while (!pq.isEmpty() && unf.isConnected(min.u, min.v)) {
                min = pq.poll();
            }
            unf.union(min.u, min.v);
            minMst += min.w;
        }

        return minMst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int path = sc.nextInt();
        Queue<Edge> q = new PriorityQueue<>();
        for(int i = 0; i < path; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Edge e = new Edge(u,v,w);
            q.add(e);
        }
        System.out.println(kruskals(n,q));
    }
}