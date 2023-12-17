import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Gift
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Queue<Integer> pq = new PriorityQueue<>();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = scanner.nextInt();
        }
        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            pq.add(a[i]);
            if (i < k)
            {
                sum += a[i];
            }
            else
            {
                sum += a[i] - pq.poll();
            }
            System.out.print(sum + " ");
        }
    }
}