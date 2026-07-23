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
            if (grade != null && grade.getStudentId() != null && iD.equals(grade.getStudentId())){
                return grade;
            }
        }
        return null;
    }
}
