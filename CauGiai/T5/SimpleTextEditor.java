import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String text = "";
        int q = sc.nextInt();
        int request;
        Stack<String> oldVersion = new Stack<>();

        for (int i = 0; i < q; i++) {
            request = sc.nextInt();
            switch (request) {
                case 1: {
                    oldVersion.push(text);
                    String append = sc.next();
                    text += append;
                    break;
                }
                case 2: {
                    oldVersion.push(text);
                    int k = sc.nextInt();
                    text = text.substring(0, text.length() - k);
                    break;
                }
                case 3: {
                    int k = sc.nextInt();
                    System.out.println(text.charAt(k-1));
                    break;
                }
                case 4: {
                    if(!oldVersion.isEmpty()) {
                        String oldText = oldVersion.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }
    }
}