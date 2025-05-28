import java.util.*;

class Subject {
    String name;
    int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

class Student {
    String name;
    List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(String subjectName, int score) {
        subjects.add(new Subject(subjectName, score));
    }

    public double calculateAverage() {
        int totalScore = 0;
        for (Subject subject : subjects) {
            totalScore += subject.getScore();
        }
        return subjects.isEmpty() ? 0 : (double) totalScore / subjects.size();
    }

    public String getName() {
        return name;
    }
}

class School {
    Map<String, Student> students;

    public School() {
        this.students = new HashMap<>();
    }

    public void addStudent(String studentName, String subjectName, int score) {
        students.putIfAbsent(studentName, new Student(studentName));
        students.get(studentName).addSubject(subjectName, score);
    }

    public Student findTopStudent() {
        Student topStudent = null;
        double highestAverage = 0;

        for (Student student : students.values()) {
            double average = student.calculateAverage();
            if (average > highestAverage) {
                highestAverage = average;
                topStudent = student;
            }
        }

        return topStudent;
    }
}

public class Java_Object_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        School school = new School();

        int numEntries = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 소비

        for (int i = 0; i < numEntries; i++) {
            String[] input = scanner.nextLine().split(" ");
            String studentName = input[0];
            String subjectName = input[1];
            int score = Integer.parseInt(input[2]);

            school.addStudent(studentName, subjectName, score);
        }

        Student topStudent = school.findTopStudent();
        if (topStudent != null) {
            System.out.println("Top student: " + topStudent.getName() + " with an average score of " + topStudent.calculateAverage());
        } else {
            System.out.println("No students found.");
        }

        scanner.close();
    }
}
