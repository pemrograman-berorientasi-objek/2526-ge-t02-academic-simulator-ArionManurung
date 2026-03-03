package academic.driver;

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
        // Menggunakan List untuk menyimpan Course, Student, dan Enrollment agar urutan inputnya terjaga
        Map<String, Course> courseMap = new HashMap<>();
        List<Course> coursesOutputOrder = new ArrayList<>(); // List untuk menjaga urutan output Course

        Map<String, Student> studentMap = new HashMap<>();
        List<Student> studentsOutputOrder = new ArrayList<>(); // List untuk menjaga urutan output Student

        List<Enrollment> enrollments = new ArrayList<>(); // Enrollment sudah menggunakan List, jadi urutan terjaga

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
                        courseMap.put(code, course); // Simpan course ke map untuk lookup
                        coursesOutputOrder.add(course); // Simpan course ke list untuk output berurutan
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
                        studentMap.put(id, student); // Simpan student ke map untuk lookup
                        studentsOutputOrder.add(student); // Simpan student ke list untuk output berurutan
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
                            // Grade default "None" sesuai model
                            Enrollment enrollment = new Enrollment(course, student, academicYear, semester);
                            enrollments.add(enrollment); // Simpan enrollment ke list
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
        // 1. Tampilkan semua Courses sesuai urutan input
        for (Course course : coursesOutputOrder) {
            System.out.println(course.toString());
        }

        // 2. Tampilkan semua Students sesuai urutan input
        for (Student student : studentsOutputOrder) {
            System.out.println(student.toString());
        }

        // 3. Tampilkan semua Enrollments sesuai urutan input
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        scanner.close();
    }
}