import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> ans = new ArrayList<Double>();
        int n = a.size();
        List<Integer> res = new ArrayList<Integer>();
        int sz = 0;
        for(int i=0; i<n; ++i) {
            res.add(a.get(i));
            ++sz;
            Collections.sort(res);
            double median = 0;
            if(sz%2==0) {
                median = (double)(res.get(sz/2) + res.get(sz/2-1))/2;
            } else {
                median = (double)res.get((sz-1)/2);
            }
            ans.add(median);
        }
        return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
