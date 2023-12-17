import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < A.size(); i++) {
            pq.add(A.get(i));
        }

        int ans = 0;

        while (!pq.isEmpty() && pq.peek() < k && pq.size() > 1) {
            int temp = pq.poll();
            pq.add(temp + 2 * pq.poll());
            ans++;
        }
        if (pq.isEmpty() || pq.peek() < k) return -1;
        return ans;
    }

    static class PriorityQueue {
        private List<Integer> list;

        public PriorityQueue() {
            this.list = new ArrayList<>();
        }

        public void add(int element) {
            list.add(element);
            heapifyUp();
        }

        public int poll() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }

            int result = list.get(0);
            int lastElement = list.remove(list.size() - 1);

            if (!isEmpty()) {
                list.set(0, lastElement);
                heapifyDown();
            }

            return result;
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }

            return list.get(0);
        }

        public int size() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        private void heapifyUp() {
            int currentIndex = list.size() - 1;
            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (list.get(currentIndex) < list.get(parentIndex)) {
                    swap(currentIndex, parentIndex);
                    currentIndex = parentIndex;
                } else {
                    break;
                }
            }
        }

        private void heapifyDown() {
            int currentIndex = 0;
            while (true) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int smallest = currentIndex;
                if (leftChildIndex < list.size() && list.get(leftChildIndex) < list.get(smallest)) {
                    smallest = leftChildIndex;
                }
                if (rightChildIndex < list.size() && list.get(rightChildIndex) < list.get(smallest)) {
                    smallest = rightChildIndex;
                }
                if (smallest != currentIndex) {
                    swap(currentIndex, smallest);
                    currentIndex = smallest;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = Result.cookies(k, A);

        System.out.println(result);

        bufferedReader.close();
    }
}