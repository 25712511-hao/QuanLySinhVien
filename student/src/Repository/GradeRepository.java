package Repository;

import Entity.Grade;
import java.util.ArrayList;
import java.util.List;

public class GradeRepository {
    private List<Grade> gradeList = new ArrayList<>();

    public ArrayList<Grade> saveScores(){
        return (ArrayList<Grade>) gradeList;
    }
    public ArrayList<Grade> getScores(){
        return (ArrayList<Grade>) gradeList;
    }
}