import java.util.Scanner;

public class Course {
    private int classId;
    int totalStudentl;
    String classroomId;
    String subjname;
    String lStudent;
    Scanner sc = new Scanner(System.in);
    private int capacity;

    public Course() {};

    public Course(int classId, int capacity) {
        this.classId = classId;
        this.capacity = capacity;
    }

    public int getClassId() {
        return classId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
