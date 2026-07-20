package Control;

import Entity.Student;
import Repository.StudentRepository;
import Control.Interfaces.ITypeCasting;
import java.util.ArrayList;

public class StudentBusinessLogic implements ITypeCasting{
    StudentRepository storage = new StudentRepository();
    CheckStorage checkStorage = new CheckStorage(storage);
    CheckData checkData = new CheckData(storage);
    CheckedResult validable;
    UpdateSelection[] options = UpdateSelection.values();

    public StudentRepository getStorage() {
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
    public boolean saveData(String name, String id, int year, String schoolClass, String email, int intakeNumber){
        if (checkStorage.found(id) != null){
            return false;
        }
        else {
            storage.saveData().add(new Student(name, id, year, schoolClass.toUpperCase(), email, intakeNumber));
            return true;
        }
    }
    public Student getStudentById(String id) {
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
    public ArrayList<Student> getAllStudent(){
        return storage.getStudents();
    }

    public boolean updateStudentInfo(String id, UpdateSelection option, String newValue){
        Student stu = checkStorage.found(id);
        if (stu == null){
            return false;
        }
        else{
               switch (option) {
                   case NAME -> {
                       validable = checkData.checkName(newValue);
                       if (!validable.isResult()) {
                           return false;
                       }
                       else {
                           stu.setName(newValue);
                       }
                   }

                   case ID -> {
                       validable = checkData.checkId(newValue, storage);
                       if (!validable.isResult()) {
                           return false;
                       }
                       else {
                           stu.setId(newValue);
                       }

                   }

                   case BIRTHYEAR -> {
                       validable = checkData.checkYear(newValue);
                       if (!validable.isResult()){
                           return false;
                       }
                       else {
                           int value = stringToInt(newValue);
                           stu.setBirthYear(value);
                       }
                   }

                   case SCHOOLCLASS -> {
                       validable = checkData.checkSchoolClass(newValue);
                       if (!validable.isResult()){
                           return false;
                       }
                       else {
                           stu.setSchoolClass(newValue);
                       }
                   }
                   case EMAIL -> {
                       validable = checkData.chekEmail(newValue);
                       if (!validable.isResult()){
                           return false;
                       }
                       else {
                           stu.setEmail(newValue);
                       }
                   }
                   case INTAKENUMBER -> {
                       validable = checkData.checkName(newValue);
                       if (!validable.isResult()){
                           return false;
                       }
                       else {
                           int value = stringToInt(newValue);
                           stu.setIntakeNumber(value);
                       }
                   }
                   default -> {
                       return false;
                   }
               }
           }
        return true;
    }


    public boolean deleteStudentInfo(String id, UpdateSelection option){
        Student stu = checkStorage.found(id);
        if (stu == null){
            return false;
        }
        else{
            switch (option) {
                case NAME -> {
                        stu.setName("");
                }

                case ID -> {
                        stu.setId("");
                }

                case BIRTHYEAR -> {
                        stu.setBirthYear(0);
                }

                case SCHOOLCLASS -> {
                        stu.setSchoolClass("");
                }
                case EMAIL -> {
                        stu.setEmail("");
                }
                case INTAKENUMBER -> {
                        stu.setIntakeNumber(0);
                    }
                }
            }
        return true;
    }

    public boolean deteleAllInfo(String id){
        Student stu = checkStorage.found(id);
        if (stu == null){
            return false;
        }
        else{
            storage.getStudents().remove(stu);
            return true;
        }
    }
}
