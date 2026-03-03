package academic.driver;

// @author-12S24014 Arion Manurung

import academic.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>(); // Menggunakan ArrayList untuk menyimpan Student

        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#"); // Pisahkan input dengan '#'
            if (parts.length == 4) { // Memastikan format input sesuai (ID#Name#Year#Major)
                String id = parts[0];
                String name = parts[1];
                String year = parts[2];
                String major = parts[3];
                Student student = new Student(id, name, year, major); // Buat objek Student
                students.add(student); // Tambahkan ke daftar
            }
        }

        // Tampilkan semua students yang tersimpan
        for (Student student : students) {
            System.out.println(student.toString()); // Gunakan toString() dari kelas Student
        }

        scanner.close();
    }
}