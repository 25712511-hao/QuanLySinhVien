package Repository;

import Entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private List<Subject> subjectList = new ArrayList<>();

    public ArrayList<Subject> saveSubjects(){
        return (ArrayList<Subject>) subjectList;
    }
    public ArrayList<Subject> getSubjects(){
        return (ArrayList<Subject>) subjectList;
    }
}