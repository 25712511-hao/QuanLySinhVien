package Repository;

import Entity.Student;

import java.util.ArrayList;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Student> saveData(){
        return students;
    }
    public ArrayList<Student> getStudents(){
        return students;
    }
}
