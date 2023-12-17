import java.io.*;
import java.util.*;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student() {
    }

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    //Complete the code
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public String toString() {
        return name;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        } else if (!s1.getName().equals(s2.getName())) {
            return s1.getName().compareTo(s2.getName());
        }
        return Integer.compare(s2.getId(), s1.getId());
    }
}

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            students.add(new Student(id, name, cgpa));
        }
        Collections.sort(students, new StudentComparator());
        for(Student x : students) {
            System.out.println(x);
        }
    }
}