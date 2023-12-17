import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID)
        );

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                int id = Integer.parseInt(parts[3]);
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);

                pq.offer(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<>(pq);
        remainingStudents.sort(Comparator.comparing(Student::getID));

        return remainingStudents;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalEvents = Integer.parseInt(scanner.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- > 0) {
            events.add(scanner.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }

        scanner.close();
    }
}
