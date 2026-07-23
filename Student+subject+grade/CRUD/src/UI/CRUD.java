package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUD {
    public void CRUD(){
        Scanner scan = new Scanner(System.in);
        StudentCRUD stu = new StudentCRUD();
        GradeCRUD grade = new GradeCRUD();
        SubjectCRUD sub = new SubjectCRUD();
        boolean again;
        int options = -1;
        System.out.println("===Mời Lựa chọn===");
        do {
            again = false;
            System.out.println("1. Nhập thông tin sinh viên\n2. Nhập điểm sinh viên\n3. Nhập môn học\nNhấn 0 để thoát chương trình");
            try {
                options = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ");
                again = true;
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
                case 0: {
                    System.out.println("Thoát chương trình");
                    break;
                }
                default : {
                    System.out.println("Lựa chọn không tồn tại");
                    again = true;
                }
            }
        }while (again);
    }
}
