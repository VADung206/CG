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
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for(int i = 1; i < n; i++)
        {
            if(arr.get(i) < arr.get(i-1))
            {
                int j = i;
                while(j > 0 && arr.get(j) < arr.get(j - 1))
                {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j-1));
                    arr.set(j-1, temp);
                    j--;
                }
            }
            for(int k = 0; k < n; k++)
            {
                System.out.print(arr.get(k) + " ");
            }
            System.out.println("");
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
