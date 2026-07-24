package Control;

import Entity.Grade;
import Entity.Subject;
import Repository.GradeRepository;
import Repository.SubjectRepository;

public class CheckSubjectStorage {
    SubjectRepository list;

    public CheckSubjectStorage(SubjectRepository list) {
        this.list = list;
    }

    public Subject found(String iD){
        for (Subject grade : list.getSubjects()){
            if (grade.getSubjectId().equals(iD)){
                return grade;
            }
        }
        return null;
    }
}
