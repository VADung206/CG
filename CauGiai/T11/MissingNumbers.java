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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> missNum = new ArrayList<>();
        Map<Integer, Integer> mapArr = new HashMap<>();
        Map<Integer, Integer> mapBrr = new HashMap<>();
        for(int a : arr) {
            if(!mapArr.containsKey(a)) {
                mapArr.put(a, 1);
            }
            else {
                mapArr.put(a, mapArr.get(a) + 1);
            }
        }
        for(int b : brr) {
            if(!mapBrr.containsKey(b)) {
                mapBrr.put(b, 1);
            }
            else {
                mapBrr.put(b, mapBrr.get(b) + 1);
            }
        }
        Set<Integer> setB = mapBrr.keySet();
        for (Integer keyB : setB) {

            if(!mapArr.containsKey(keyB)) {
                missNum.add(keyB);
            }
            else if(mapBrr.get(keyB) > mapArr.get(keyB)) {
                missNum.add(keyB);
            }
        }
        Collections.sort(missNum);
        return missNum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
