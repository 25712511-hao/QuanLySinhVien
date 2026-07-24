package UI;

import Control.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUD {
    public void CRUD() throws IOException {
        Scanner scan = new Scanner(System.in);

        StudentBusinessLogic studentBL = new StudentBusinessLogic();
        GradeBusinessLogic gradeBL = new GradeBusinessLogic();
        SubjectBusinessLogic subjectBL = new SubjectBusinessLogic();

        StudentCRUD stu = new StudentCRUD(studentBL);
        GradeCRUD grade = new GradeCRUD(subjectBL,gradeBL);
        SubjectCRUD sub = new SubjectCRUD(subjectBL, gradeBL);
        boolean again;
        int options = -1;
        do {
            System.out.println();
            System.out.println("===Mời Lựa chọn===");
            again = true;
            System.out.println("1. Nhập thông tin sinh viên\n2. Nhập điểm sinh viên\n3. Nhập môn học\n4. In ra sinh viên phải học lại\nNhấn 0 để thoát chương trình");
            try {
                options = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ");
                scan.nextLine();
                continue;
            }
            switch (options){
                case 1: {
                    stu.seclectCRUD();
                    break;
                }
                case 2 : {
                    grade.seclectCRUD();
                    break;
                }
                case 3 :{
                    sub.seclectCRUD();
                    break;
                }
                case 4: {
                    FileOutput file = new FileOutput(studentBL, gradeBL, subjectBL);
                    file.retakeStudent();
                    boolean result = file.writeToFile();
                    if (!result){
                        System.out.println("\nGhi thất bại");
                    }
                    else {
                        System.out.println("\nGhi thành công\nDữ liệu được ghi vào file: Test.txt");
                    }
                    break;
                }
                case 0: {
                    System.out.println();
                    System.out.println("---THOÁT CHƯƠNG TRÌNH---");
                    again = false;
                    break;
                }
                default : {
                    System.out.println();
                    System.out.println("Lựa chọn không tồn tại");

                }
            }
        }while (again);
    }
}
