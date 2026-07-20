package Control;

import Entity.Student;
import Repository.StudentRepository;

public class CheckStorage {
    StudentRepository list;

    public CheckStorage(StudentRepository list) {
        this.list = list;
    }

    public Student found(String iD){
        for (Student sv : list.getStudents()){
            if (sv.getId().equals(iD)){
                return sv;
            }
        }
        return null;
    }
}
