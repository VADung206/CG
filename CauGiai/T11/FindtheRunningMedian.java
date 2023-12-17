import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        int size = a.size();
        Queue<Integer> maxPQ = new PriorityQueue(size / 2 + 1, Collections.reverseOrder());
        Queue<Integer> minPQ = new PriorityQueue(size / 2 + 1);
        List<Double> ans = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(maxPQ.isEmpty() || maxPQ.peek() >= a.get(i)) {
                maxPQ.add(a.get(i));
            }
            else {
                minPQ.add(a.get(i));
            }

            if(maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            }
            else if(maxPQ.size() < minPQ.size()) {
                maxPQ.add(minPQ.poll());
            }
            if(i % 2 == 0) {
                ans.add(maxPQ.peek() / 1.0);
            } else {
                ans.add((maxPQ.peek() + minPQ.peek()) / 2.0);
            }
        }
        return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
