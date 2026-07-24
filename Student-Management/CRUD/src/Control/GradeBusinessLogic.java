package Control;
import Entity.Grade;
import Repository.GradeRepository;
import Control.Interfaces.ITypeCasting;
import java.util.ArrayList;

public class GradeBusinessLogic implements ITypeCasting{
    GradeRepository storage = new GradeRepository();
    CheckGradeStorage checkGradeStorage = new CheckGradeStorage(storage);
    CheckGradeData checkGradeData = new CheckGradeData(storage);
    CheckedResult validable;
    UpdateGradeSelection[] options = UpdateGradeSelection.values();

    public GradeRepository getStorage() {
        return storage;
    }

    public int checkOption(String option){
        char[] c = option.toCharArray();
        for (int i = 0 ; i < c.length; i++){
            if (!Character.isDigit(c[i])){
                return -1;
            }
        }
        return Integer.parseInt(option);
    }

    public boolean saveData( String id, String idSubject, double scoreCc, double scoreGk, double scoreCk){
        if (checkGradeStorage.found(id) != null){
            return false;
        }
        else {
            double gpa = (scoreCc * 0.1) + (scoreGk * 0.3) + (scoreCk * 0.6);
            gpa = Math.round(gpa * 100.0) / 100.0;
            storage.saveScores().add(new Grade(id, idSubject, scoreCc, scoreGk, scoreCk));
            return true;
        }
    }
    public Grade getGradeById(String id) {
        return checkGradeStorage.found(id);
    }
    public boolean validOption(int n) {
        try{
            if (n-1>options.length || n-1<0){
                throw new ArrayIndexOutOfBoundsException("Lựa chọn không hợp lệ");
            }
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    public ArrayList<Grade> getAllGrade(){
        return storage.getScores();
    }

    public boolean updateGradeInfo(String id, UpdateGradeSelection option, String newValue){
        Grade grade = checkGradeStorage.found(id);
        if (grade == null){
            return false;
        }
        else{
            switch (option) {
                case ID -> {
                    validable = checkGradeData.checkId(newValue);
                    if (!validable.isResult()) {
                        return false;
                    }
                    else {
                        grade.setStudentId(newValue);
                    }
                }

                case IDSUBJECT -> {
                    validable = checkGradeData.checkIDSubject(newValue);
                    if (!validable.isResult()) {
                        return false;
                    }
                    else {
                        grade.setSubjectId(newValue);
                    }

                }

                case SCORECC -> {
                    validable = checkGradeData.checkScore(newValue);
                    if (!validable.isResult()){
                        return false;
                    }
                    else {
                        double value = stringToScore(newValue);
                        grade.setScoreCc(value);
                    }
                }

                case SCOREGK -> {
                    validable = checkGradeData.checkScore(newValue);
                    if (!validable.isResult()){
                        return false;
                    }
                    else {
                        double value = stringToScore(newValue);
                        grade.setScoreGk(value);
                    }
                }

                case SCORECK -> {
                    validable = checkGradeData.checkScore(newValue);
                    if (!validable.isResult()){
                        return false;
                    }
                    else {
                        double value = stringToScore(newValue);
                        grade.setScoreCk(value);
                    }
                }

                default -> {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean deleteStudentInfo(String id, UpdateGradeSelection option) {
        Grade grade = checkGradeStorage.found(id);
        if (grade == null) {
            return false;
        } else {
            switch (option) {
                case ID -> {
                    grade.setStudentId("");
                }

                case IDSUBJECT -> {
                    grade.setSubjectId("");
                }

                case SCORECC -> {
                    grade.setScoreCc(0);
                }

                case SCOREGK -> {
                    grade.setScoreGk(0);
                }
                case SCORECK -> {
                    grade.setScoreCk(0);
                }
                default -> {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean deteleAllInfo(String id){
        Grade grade = checkGradeStorage.found(id);
        if (grade == null){
            return false;
        }
        else{
            storage.getScores().remove(grade);
            return true;
        }
    }
}
