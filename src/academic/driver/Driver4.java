package academic.driver;

// @author-12S24014 Arion Manurung

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Driver4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menggunakan Map untuk menyimpan Course dan Student agar mudah dicari berdasarkan ID/Code
        Map<String, Course> courseMap = new HashMap<>();
        Map<String, Student> studentMap = new HashMap<>();
        List<Enrollment> enrollments = new ArrayList<>(); // Enrollments bisa disimpan di List

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");
            String command = parts[0]; // Perintah pertama (e.g., "course-add")

            switch (command) {
                case "course-add":
                    // Input: course-add#12S2203#Object-oriented Programming#3#C
                    if (parts.length == 5) {
                        String code = parts[1];
                        String name = parts[2];
                        int credit = Integer.parseInt(parts[3]);
                        String grade = parts[4];
                        Course course = new Course(code, name, credit, grade);
                        courseMap.put(code, course); // Simpan course ke map
                    }
                    break;
                case "student-add":
                    // Input: student-add#12S20999#Wiro Sableng#2020#Information Systems
                    if (parts.length == 5) {
                        String id = parts[1];
                        String name = parts[2];
                        String year = parts[3];
                        String major = parts[4];
                        Student student = new Student(id, name, year, major);
                        studentMap.put(id, student); // Simpan student ke map
                    }
                    break;
                case "enrollment-add":
                    // Input: enrollment-add#12S2203#12S20999#2021/2022#even
                    if (parts.length == 5) {
                        String courseCode = parts[1];
                        String studentId = parts[2];
                        String academicYear = parts[3];
                        String semester = parts[4];

                        // Cari objek Course dan Student yang sudah ada di map
                        Course course = courseMap.get(courseCode);
                        Student student = studentMap.get(studentId);

                        if (course != null && student != null) {
                            // Jika Course dan Student ditemukan, baru buat Enrollment
                            Enrollment enrollment = new Enrollment(course, student, academicYear, semester);
                            enrollments.add(enrollment); // Simpan enrollment
                        } else {
                            // Pesan peringatan jika course atau student tidak ditemukan (opsional)
                            System.err.println("Warning: Course " + courseCode + " or Student " + studentId + " not found for enrollment. Skipping.");
                        }
                    }
                    break;
                default:
                    System.err.println("Unknown command: " + command + ". Skipping line.");
                    break;
            }
        }

        // --- Bagian Output Disesuaikan ---
        // 1. Tampilkan semua Courses
        for (Course course : courseMap.values()) {
            System.out.println(course.toString());
        }

        // 2. Tampilkan semua Students
        for (Student student : studentMap.values()) {
            System.out.println(student.toString());
        }

        // 3. Tampilkan semua Enrollments
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        scanner.close();
    }
}