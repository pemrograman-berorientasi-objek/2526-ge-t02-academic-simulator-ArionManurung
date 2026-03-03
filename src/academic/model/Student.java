package academic.model;

// @author-12S24014 Arion Manurung

public class Student {
    private String id;
    private String name;
    private String year; // Tahun masuk
    private String major;

    public Student(String id, String name, String year, String major) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.major = major;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    // Metode toString untuk format output Task 02 dan Task 04
    @Override
    public String toString() {
        return id + "|" + name + "|" + year + "|" + major;
    }
}