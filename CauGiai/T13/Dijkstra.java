import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Node implements Comparable<Node> {
    public int v;
    public int e;

    public Node(int val, int end) {
        v = val;
        e = end;
    }


    @Override
    public int compareTo(Node o) {
        if (this.v != o.v) {
            return Integer.compare(this.v, o.v);
        } else {
            return Integer.compare(this.e, o.e);
        }
    }
}
class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int b = edge.get(0);
            int e = edge.get(1);
            int w = edge.get(2);
            adj.get(b).add(new Node(w, e));
            adj.get(e).add(new Node(w, b));
        }

        int[] marked = new int[n + 1];
        Arrays.fill(marked, Integer.MAX_VALUE);
        marked[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, s));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (marked[node.e] >= node.v) {
                for (Node x : adj.get(node.e)) {
                    if (marked[x.e] > node.v + x.v) {
                        marked[x.e] = node.v + x.v;
                        pq.add(new Node(marked[x.e], x.e));
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (marked[i] == Integer.MAX_VALUE) {
                res.add(-1);
            } else if (i != s) {
                res.add(marked[i]);
            }
        }

        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.shortestReach(n, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}