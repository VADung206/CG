package Bonus.Start_up;

import java.util.*;

public class Solution {
    static class MyPair implements Comparable<MyPair> {
        int value;
        int pos;

        public MyPair(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }

        @Override
        public int compareTo(MyPair other) {
            if (this.value == other.value) {
                return Integer.compare(this.pos, other.pos);
            }
            return Integer.compare(this.value, other.value);
        }
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long amount = 0;
        int event, marry;
        PriorityQueue<MyPair> minPQ = new PriorityQueue<>();

        for (int i = 0; i < N - 1; i++) {
            event = sc.nextInt();
            if (event == 1) {
                int addNum = sc.nextInt();
                minPQ.add(new MyPair(addNum, i + 1));
            } else if (event == 2) {
                marry = sc.nextInt();
                while (minPQ.size() >= marry) {
                    minPQ.poll();
                }
            }
        }
        event = sc.nextInt();
        marry = sc.nextInt();
        if (minPQ.size() < marry) {
            System.out.println(-1);
        } else {
            PriorityQueue<Integer> minPos = new PriorityQueue<>();
            for (MyPair m : minPQ) {
                amount += m.value;
                minPos.add(m.pos);
            }
            System.out.println(amount);
            while (!minPos.isEmpty()) {
                System.out.print(minPos.poll() + " ");
            }
        }
    }
}