import java.util.*;

public class Whoisinthemiddle {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int queries = sc.nextInt();
        long[] a = new long[n + 1];
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
        {
            a[i] = sc.nextInt();
            if (maxHeap.isEmpty() || a[i] < maxHeap.peek()) {
                maxHeap.offer(a[i]);
            } else {
                minHeap.offer(a[i]);
            }

            if (Math.abs(maxHeap.size() - minHeap.size()) >= 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }


        for (int i = 1; i <= queries; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                Long q = sc.nextLong();
                if (minHeap.size() == 0 && maxHeap.size() == 0) {
                    minHeap.offer(q);
                } else if (minHeap.size() == 0) {
                    if (q > maxHeap.peek()) minHeap.offer(q);
                    else maxHeap.offer(q);
                } else if (maxHeap.size() == 0) {
                    if (q > minHeap.peek()) minHeap.offer(q);
                    else maxHeap.offer(q);
                } else if (q > minHeap.peek()) {
                    minHeap.offer(q);
                } else maxHeap.offer(q);
                while (Math.abs(maxHeap.size() - minHeap.size()) >= 2) {
                    if (maxHeap.size() > minHeap.size()) {
                        minHeap.add(maxHeap.poll());
                    } else {
                        maxHeap.add(minHeap.poll());
                    }
                }
            }
            if (t == 2) {
                if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                    //System.out.println(0);
                    continue;
                }
                if (maxHeap.size() == minHeap.size()) {
                    //System.out.println(higher.poll());
                    maxHeap.poll();
                } else {
                    if (maxHeap.size() < minHeap.size()) {
                        //System.out.println(higher.poll());
                        minHeap.poll();
                    } else maxHeap.poll();
                }
            }
            if (t == 3) {
                if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                if (maxHeap.size() == minHeap.size()) {
                    System.out.println(maxHeap.peek());
                } else {
                    if (maxHeap.size() < minHeap.size()) {
                        System.out.println(minHeap.peek());
                    } else System.out.println(maxHeap.peek());
                }
            }
        }
    }
}
