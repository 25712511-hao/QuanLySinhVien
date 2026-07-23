package Control;

import Entity.Student;
import Repository.StudentRepository;

public class CheckStorage {
    StudentRepository list;

    public CheckStorage(StudentRepository list) {
        this.list = list;
    }

    public Student found(String iD){
        for (Student stu : list.getStudents()){
            if (stu.getId().equals(iD)){
                return stu;
            }
        }
        return null;
    }
}
