package academic.driver;

// @author-12S24014 Arion Manurung

import academic.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>(); // Menggunakan ArrayList sebagai media penyimpanan

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("---")) { // Perintah berhenti
                break;
            }

            String[] parts = line.split("#"); // Pisahkan input dengan '#'
            if (parts.length == 4) { // Memastikan format input sesuai (Code#Name#Credit#Grade)
                String code = parts[0];
                String name = parts[1];
                int credit = Integer.parseInt(parts[2]); // Konversi SKS ke integer
                String grade = parts[3];
                Course course = new Course(code, name, credit, grade); // Buat objek Course
                courses.add(course); // Tambahkan ke daftar
            }
        }

        // Tampilkan semua courses yang tersimpan
        for (Course course : courses) {
            System.out.println(course.toString()); // Gunakan toString() dari kelas Course
        }

        scanner.close();
    }
}