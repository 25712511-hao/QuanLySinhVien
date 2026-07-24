package Control;
import Control.Interfaces.*;
import Entity.Subject;
import Repository.SubjectRepository;

import java.util.ArrayList;

public class SubjectBusinessLogic implements ITypeCasting{
    SubjectRepository storage = new SubjectRepository();
    CheckSubjectStorage checkStorage = new CheckSubjectStorage(storage);
    CheckSubjectData checkSubjectData = new CheckSubjectData(storage);
    CheckedResult validable;
    UpdateSubjectSelection[] options = UpdateSubjectSelection.values();

    public SubjectRepository getStorage() {
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

    public boolean saveSubjectData( String idSubject, String  subjectName, int credits){
        if (checkStorage.found(idSubject) != null){
            return false;
        }
        else {
            storage.saveSubjects().add(new Subject(subjectName, idSubject, credits));
            return true;
        }
    }
    public Subject getSubjectById(String id) {
        return checkStorage.found(id);
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
    public ArrayList<Subject> getAllSubject(){
        return storage.getSubjects();
    }

    public boolean updateSubjectInfo(String id, UpdateSubjectSelection option, String newValue){
        Subject sub = checkStorage.found(id);
        if (sub == null){
            return false;
        }
        else{
               switch (option) {
                   case SUBJECTNAME -> {
                       validable = checkSubjectData.checkSubjectName(newValue);
                       if (!validable.isResult()) {
                           return false;
                       }
                       else {
                           sub.setSubjectName(newValue);
                       }
                   }

                   case IDSUBJECT -> {
                       validable = checkSubjectData.checkIDSubject(newValue);
                       if (!validable.isResult()) {
                           return false;
                       }
                       else {
                           sub.setSubjectId(newValue);
                       }

                   }

                   case CREDITS -> {
                       validable = checkSubjectData.checkCredits(newValue);
                       if (!validable.isResult()){
                           return false;
                       }
                       else {
                           int value = stringToInt(newValue);
                           sub.setCredits(value);
                       }
                   }

                   default -> {
                       return false;
                   }
               }
           }
        return true;
    }

    public boolean deleteStudentInfo(String id, UpdateSubjectSelection option) {
        Subject sub = checkStorage.found(id);
        if (sub == null) {
            return false;
        } else {
            switch (option) {
                case SUBJECTNAME -> {
                    sub.setSubjectName("");
                }

                case IDSUBJECT -> {
                    sub.setSubjectId("");
                }

                case CREDITS -> {
                    sub.setCredits(0);
                }
                default -> {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean deteleAllInfo(String id){
        Subject sub = checkStorage.found(id);
        if (sub == null){
            return false;
        }
        else{
            storage.getSubjects().remove(sub);
            return true;
        }
    }
}
