package academic.model;

// @author-12S24014 Arion Manurung

public class Course {
    private String code;
    private String name;
    private int credit;
    private String grade; // Tetap ada sesuai input Task 01

    public Course(String code, String name, int credit, String grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    // Setter method (jika grade bisa diubah, seperti pada Enrollment)
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Metode toString untuk format output Task 01 dan Task 04
    @Override
    public String toString() {
        return code + "|" + name + "|" + credit + "|" + grade;
    }
}