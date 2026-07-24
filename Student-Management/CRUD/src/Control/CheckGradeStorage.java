package Control;

import Entity.Grade;
import Repository.GradeRepository;
public class CheckGradeStorage {
    GradeRepository list;

    public CheckGradeStorage(GradeRepository list) {
        this.list = list;
    }

    public Grade found(String iD){
        for (Grade grade : list.getScores()){
            if (grade.getStudentId().equals(iD)){
                return grade;
            }
        }
        return null;
    }
}
