package UI;

import java.util.Scanner;
import Control.*;
import Control.Interfaces.ITypeCasting;
import Repository.StudentRepository;

public class DataInput implements ITypeCasting {
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

    public DataInput(StudentRepository repo) {
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

    public String setEmailInput() {
        do {
            System.out.println("Nhập email của sinh viên (Vd: iuh123@gmail.com thì nhập iuh123):");
            email = scan.nextLine();
            check = checkData.chekEmail(email);
            System.out.println(check.getNotification());
        } while (!check.isResult());
        email = email.concat("@gmail.com");
        return email;
    }

    public int setIntakeNumberInput(){
        do{
            System.out.println("Nhập khóa của sinh viên (K21 thì nhập 21, K20 thì nhập 20) :");
            intakeNumber = scan.nextLine();
            check = checkData.checkIntakeNumber(intakeNumber);
            System.out.println(check.getNotification());
        } while(!check.isResult());
        return stringToInt(intakeNumber);
    }
}
