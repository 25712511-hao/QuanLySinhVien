package UI;

import java.util.Scanner;
import Control.*;
import Control.Interfaces.ITypeCasting;
import Repository.StudentRepository;

public class StudentDataInput implements ITypeCasting {
    Scanner scan = new Scanner(System.in);
    String name;
    String iD;
    String year;
    String schoolClass;
    String email;
    String intakeNumber;
    CheckData checkData;
    CheckedResult check;
    StudentRepository repo;

    public StudentDataInput(StudentRepository repo) {
        this.repo = repo;
        this.checkData = new CheckData(repo);
    }

    public String setNameInput(){
        do{
            System.out.println("Nhập tên của sinh viên:");
            name = scan.nextLine();
            check = checkData.checkName(name);
            System.out.println(check.getNotification());
        } while(!check.isResult());
        return name;
    }
    public String setIDInput() {
        do {
            System.out.println("Nhập mã số sinh viên:");
            iD = scan.nextLine();
            check = checkData.checkId(iD, repo);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return iD;
    }

    public int setYearInput() {
        do {
            System.out.println("Nhập năm sinh của sinh viên:");
            year = scan.nextLine();
            check = checkData.checkYear(year);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return stringToInt(year);
    }

    public String setSchoolClassInput() {
        do {
            System.out.println("Nhập tên lớp học sinh viên (Thêm 0 vào cuối nếu là hệ đại trà, thêm 1 vào cuối nếu là hệ chất lượng cao) :");
            schoolClass = scan.nextLine();
            check = checkData.checkSchoolClass(schoolClass);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        return schoolClass;
    }
}
