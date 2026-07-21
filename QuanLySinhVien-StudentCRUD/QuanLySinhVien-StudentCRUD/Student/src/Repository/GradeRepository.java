package Repository;

import Entity.Grade;
import java.util.ArrayList;
import java.util.List;

public class GradeRepository {
    private List<Grade> grades = new ArrayList<>();

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public List<Grade> getGradesByStudentId(String studentId) {
        List<Grade> result = new ArrayList<>();
        for (Grade g : grades) {
            if (g.getStudentId() == studentId) result.add(g);
        }
        return result;
    }

    public boolean updateGrade(String studentId, String subjectId, double cc, double gk, double ck) {
        for (Grade g : grades) {
            if (g.getStudentId() == studentId && g.getSubjectId().equalsIgnoreCase(subjectId)) {
                g.setScoreCc(cc);
                g.setScoreGk(gk);
                g.setScoreCk(ck);
                return true;
            }
        }
        return false;
    }

    public boolean deleteGrade(String studentId, String subjectId) {
        return grades.removeIf(g -> g.getStudentId() == studentId
                && g.getSubjectId().equalsIgnoreCase(subjectId));
    }
}