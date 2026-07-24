package UI;

import Control.*;
import Entity.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectCRUD {
    Scanner scan = new Scanner(System.in);
    SubjectBusinessLogic serviceSubject;
    GradeBusinessLogic serviceGrade;
    DataInput input;

    public SubjectCRUD(SubjectBusinessLogic serviceSubject, GradeBusinessLogic serviceGrade) {
        this.serviceSubject = serviceSubject;
        this.serviceGrade = serviceGrade;
        this.input = new DataInput(serviceGrade.getStorage(), serviceSubject.getStorage());
    }

    private String toDisplayLabel(UpdateSubjectSelection select) {
        return switch (select) {
            case SUBJECTNAME -> "Tên môn học";
            case IDSUBJECT -> "Mã môn học";
            case CREDITS -> "Số tín chỉ";
        };
    }
    public void createSubject() {
        boolean again = false;
        do {
            String id = input.setSubjectNameInput();
            String idSubject = input.setIDSubjectInput();
            int credits = input.setCreditsSubject();
            boolean sucess = serviceSubject.saveSubjectData(id, idSubject, credits);
            if (sucess) {
                System.out.println("\nThêm thành công");
            } else {
                System.out.println("\nThêm thất bại");
                again = true;
            }
        } while (again);
    }

    public void readSubject() {
        boolean again = false;
        do {
            again = false;
            System.out.println("Chọn môn cần in ra thông tin (Nhập mã môn): ");
            String id = scan.nextLine();
            Subject studentSubject = serviceSubject.getSubjectById(id);

            if (studentSubject == null) {
                System.out.println("Khônt tìm thấy môn");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceSubject.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                    break;
                    default:
                        again = false;
                }
            } else {
                System.out.println(studentSubject);
            }
        } while (again);
    }

    public ArrayList<Subject> readAllSubject() {
        return serviceSubject.getAllSubject();
    }

    public void updateSubject() {
        boolean again = false;
        do {
            readAllSubject();
            again = false;
            System.out.println("Chọn môn cần cập nhật (nhập mã môn): ");
            String idStudent = scan.nextLine();
            Subject studentSubject = serviceSubject.getSubjectById(idStudent);
            if (studentSubject == null) {
                System.out.println("Không tìm thấy môn");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceSubject.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                System.out.println(studentSubject);
                UpdateSubjectSelection[] options = UpdateSubjectSelection.values();
                boolean checkOption;
                int n = -1;
                do {
                    System.out.println("Mời lựa chọn thông tin cần cập nhật: ");
                    for (int i = 0; i < options.length; i++) {
                        System.out.println((i + 1) + "." + toDisplayLabel(options[i]));
                    }
                    n = scan.nextInt();
                    scan.nextLine();
                   checkOption = serviceSubject.validOption(n);
                }while (!checkOption);
                UpdateSubjectSelection select = options[n - 1];

                System.out.println(" Nhập thông tin cần cập nhật:");
                String newValue = scan.nextLine();
                boolean sucess = serviceSubject.updateSubjectInfo(idStudent, select, newValue);
                if (!sucess) {
                    System.out.println("Cập nhật thất bại\nThông tin không hợp lệ hoặc lựa chọn không tồn tại");
                } else {
                    System.out.println("Cập nhật thành công");
                }
            }
        } while (again);
    }

    public void deleteSubject() {
        boolean again = false;
        do {
            readAllSubject();
            again = false;
            System.out.println("Chọn môn cần xóa (nhập mã môn): ");
            String idStudent = scan.nextLine();
            Subject studentSubject = serviceSubject.getSubjectById(idStudent);
            if (studentSubject == null) {
                System.out.println("Không tìm thấy môn");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceSubject.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                UpdateSubjectSelection[] options = UpdateSubjectSelection.values();
                System.out.println("Mời lựa chọn thông tin cần xóa: ");
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + "." + options[i]);
                }

                UpdateSubjectSelection select = options[scan.nextInt() - 1];
                scan.nextLine();

                boolean sucess = serviceSubject.deleteStudentInfo(idStudent, select);
                if (!sucess) {
                    System.out.println("Xóa thất bại");
                } else {
                    System.out.println("Xóa thành công");
                }
            }
        } while (again);
    }
    public void deteleAllSubject(){
        boolean again = false;
        do {
            readAllSubject();
            again = false;
            System.out.println("Chọn môn cần xóa (nhập mã môn): ");
            String idStudent = scan.nextLine();
            Subject studentSubject = serviceSubject.getSubjectById(idStudent);
            if (studentSubject == null) {
                System.out.println("Không tìm thấy môn");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceSubject.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                System.out.println("Xóa thành công");
                serviceSubject.deteleAllInfo(idStudent);
            }
        }while (again);
    }

    public void seclectCRUD() {
        boolean again = true;
        do {
            System.out.println();
            System.out.println("===Quản lý môn học===");
            System.out.println("Mời lựa chọn (Nhập số phía trước các lựa chọn):\n1. Nhập môn học\n2. in ra môn học\n3. In ra toàn bộ các môn\n4. Cập nhật môn học\n5. Xóa 1 thông tin 1 môn học\n6. Xóa 1 môn học\nNhấn 0 để thoát");
            int option = serviceSubject.checkOption(scan.nextLine());
            switch (option) {
                case 1:
                    System.out.println();
                    createSubject();
                    break;
                case 2:
                    System.out.println();
                    readSubject();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(readAllSubject());
                    break;
                case 4:
                    System.out.println();
                    updateSubject();
                    break;
                case 5:
                    System.out.println();
                    deleteSubject();
                    break;
                case 6:
                    System.out.println();
                    deteleAllSubject();
                    break;
                case 0:
                    again = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Lựa chọn không tồn tại");
                    break;
            }
        }while (again);
    }
}

