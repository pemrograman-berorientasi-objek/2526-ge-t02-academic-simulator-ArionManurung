package academic.model;

// @author-12S24014 Arion Manurung

public class Enrollment {
    private Course course; // Objek Course yang didaftarkan
    private Student student; // Objek Student yang mendaftar
    private String academicYear;
    private String semester;
    private String grade; // Nilai yang didapat mahasiswa, default "None"

    // Konstruktor utama tanpa grade, grade akan default "None"
    public Enrollment(Course course, Student student, String academicYear, String semester) {
        this.course = course;
        this.student = student;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Default grade sesuai contoh output Task 03
    }

    // Konstruktor overloaded jika grade langsung diberikan saat enrollment dibuat
    public Enrollment(Course course, Student student, String academicYear, String semester, String grade) {
        this.course = course;
        this.student = student;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    // Getter methods
    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Setter method untuk mengubah grade
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Metode toString untuk format output Task 03 dan Task 04
    @Override
    public String toString() {
        // Output format: CourseCode|StudentID|AcademicYear|Semester|Grade
        // Kita gunakan getCode() dan getId() dari objek Course dan Student
        return course.getCode() + "|" + student.getId() + "|" + academicYear + "|" + semester + "|" + grade;
    }
}