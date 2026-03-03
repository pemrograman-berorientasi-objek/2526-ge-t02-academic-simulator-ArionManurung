package academic.driver;

// @author-12S24014 Arion Manurung

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Enrollment> enrollments = new ArrayList<>(); // Menggunakan ArrayList untuk menyimpan Enrollment

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#"); // Pisahkan input dengan '#'
            if (parts.length == 4) { // Memastikan format input sesuai (CourseCode#StudentID#AcademicYear#Semester)
                String courseCode = parts[0];
                String studentId = parts[1];
                String academicYear = parts[2];
                String semester = parts[3];

                // Untuk Task 03, kita asumsikan Course dan Student hanya perlu kode/ID-nya saja
                // dan objek lengkapnya tidak perlu dicari dari daftar global.
                // Kita buat objek Course dan Student 'dummy' hanya dengan atribut yang relevan untuk Enrollment.
                // Ini karena contoh input/output tidak mengharuskan kita mencari objek lengkap.
                Course dummyCourse = new Course(courseCode, "", 0, "");
                Student dummyStudent = new Student(studentId, "", "", "");

                Enrollment enrollment = new Enrollment(dummyCourse, dummyStudent, academicYear, semester);
                enrollments.add(enrollment); // Tambahkan ke daftar
            }
        }

        // Tampilkan semua enrollments yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString()); // Gunakan toString() dari kelas Enrollment
        }

        scanner.close();
    }
}