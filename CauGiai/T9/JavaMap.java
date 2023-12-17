import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> phoneBook = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String phoneNumber = scanner.nextLine();
            phoneBook.put(name, phoneNumber);
        }
        while (scanner.hasNextLine()) {
            String query = scanner.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }
        scanner.close();
    }
}