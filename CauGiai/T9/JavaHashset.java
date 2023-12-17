import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniquePairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String pair = scanner.nextLine();
            uniquePairs.add(pair);
            System.out.println(uniquePairs.size());
        }

        scanner.close();
    }
}