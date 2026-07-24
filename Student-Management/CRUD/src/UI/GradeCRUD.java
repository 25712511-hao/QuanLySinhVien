package UI;

import Control.GradeBusinessLogic;
import Control.SubjectBusinessLogic;
import Entity.Grade;
import Control.UpdateGradeSelection;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeCRUD {
    Scanner scan = new Scanner(System.in);
    SubjectBusinessLogic serviceSubject;
    GradeBusinessLogic serviceGrade;
    DataInput input;

    public GradeCRUD(SubjectBusinessLogic serviceSubject, GradeBusinessLogic serviceGrade) {
        this.serviceSubject = serviceSubject;
        this.serviceGrade = serviceGrade;
       this.input  = new DataInput(serviceGrade.getStorage(), serviceSubject.getStorage());
    }

    private String toDisplayLabel(UpdateGradeSelection select) {
        return switch (select) {
            case ID -> "Mã số sinh viên";
            case IDSUBJECT -> "Mã môn học";
            case SCORECC -> "Điểm chuyên cần";
            case SCOREGK -> "Điểm giữa kì";
            case SCORECK -> "Điểm cuối kì";
        };
    }
    public void createGrade() {
        boolean again = false;
        do {
            String id = input.setIDInput();
            String idSubject = input.setIDSubjectInput();
            double scoreCc = input.setScoreCcInput();
            double scoreGk = input.setScoreGkInput();
            double scoreCk = input.setScoreCkInput();
            boolean sucess = serviceGrade.saveData(id, idSubject, scoreCc, scoreGk, scoreCk);
            if (sucess) {
                System.out.println("\nThêm thành công");
            } else {
                System.out.println("\nThêm thất bại");
                again = true;
            }
        } while (again);
    }

    public void readGrade() {
        boolean again = false;
        do {
            again = false;
            System.out.println("Chọn sinh viên cần in ra điểm (Nhập MSSV): ");
            String id = scan.nextLine();
            Grade studentGrade = serviceGrade.getGradeById(id);

            if (studentGrade == null) {
                System.out.println("Khônt tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceGrade.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                    break;
                    default:
                        again = false;
                }
            } else {
                System.out.println(studentGrade);
            }
        } while (again);
    }

    public ArrayList<Grade> readAllGrade() {
        return serviceGrade.getAllGrade();
    }

    public void updateGrade() {
        boolean again = false;
        do {
            readAllGrade();
            again = false;
            System.out.println("Chọn sinh viên cần cập nhật điểm (nhập MSSV): ");
            String idStudent = scan.nextLine();
            Grade studentGrade = serviceGrade.getGradeById(idStudent);
            if (studentGrade == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceGrade.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                System.out.println(studentGrade);
                UpdateGradeSelection[] options = UpdateGradeSelection.values();
                boolean checkOption;
                int n = -1;
                do {
                    System.out.println("Mời lựa chọn thông tin cần cập nhật: ");
                    for (int i = 0; i < options.length; i++) {
                        System.out.println((i + 1) + "." + toDisplayLabel(options[i]));
                    }
                    n = scan.nextInt();
                    scan.nextLine();
                   checkOption = serviceGrade.validOption(n);
                }while (!checkOption);
                UpdateGradeSelection select = options[n - 1];

                System.out.println(" Nhập thông tin cần cập nhật:");
                String newValue = scan.nextLine();
                boolean sucess = serviceGrade.updateGradeInfo(idStudent, select, newValue);
                if (!sucess) {
                    System.out.println("Cập nhật thất bại\nThông tin không hợp lệ hoặc lựa chọn không tồn tại");
                } else {
                    System.out.println("Cập nhật thành công");
                }
            }
        } while (again);
    }

    public void deleteGrade() {
        boolean again = false;
        do {
            readAllGrade();
            again = false;
            System.out.println("Chọn sinh viên cần xóa (nhập MSSV): ");
            String idStudent = scan.nextLine();
            Grade studentGrade = serviceGrade.getGradeById(idStudent);
            if (studentGrade == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceGrade.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                UpdateGradeSelection[] options = UpdateGradeSelection.values();
                System.out.println("Mời lựa chọn thông tin cần xóa: ");
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + "." + options[i]);
                }

                UpdateGradeSelection select = options[scan.nextInt() - 1];
                scan.nextLine();

                boolean sucess = serviceGrade.deleteStudentInfo(idStudent, select);
                if (!sucess) {
                    System.out.println("Xóa thất bại");
                } else {
                    System.out.println("Xóa thành công");
                }
            }
        } while (again);
    }
    public void deteleAllGrade(){
        boolean again = false;
        do {
            readAllGrade();
            again = false;
            System.out.println("Chọn sinh viên cần xóa (nhập MSSV): ");
            String idStudent = scan.nextLine();
            Grade studentGrade = serviceGrade.getGradeById(idStudent);
            if (studentGrade == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = serviceGrade.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                System.out.println("Xóa thành công");
                serviceGrade.deteleAllInfo(idStudent);
            }
        }while (again);
    }

    public void seclectCRUD() {
        boolean again = true;
        do {
            System.out.println();
            System.out.println("===Quản lý điểm của sinh viên===");
            System.out.println("Mời lựa chọn (Nhập số phía trước các lựa chọn):\n1.Nhập điểm của sinh viên\n2.In điểm của sinh viên\n3.In toàn bộ danh sách điểm của sinh viên\n4.Cập nhật điểm của sinh viên\n5.Xóa điểm của sinh viên\n6.Xóa toàn bộ điểm của 1 sinh viên\nNhấn 0 để thoát");
            int option = serviceGrade.checkOption(scan.nextLine());
            switch (option) {
                case 1:
                    System.out.println();
                    createGrade();
                    break;
                case 2:
                    System.out.println();
                    readGrade();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(readAllGrade());
                    break;
                case 4:
                    System.out.println();
                    updateGrade();
                    break;
                case 5:
                    System.out.println();
                    deleteGrade();
                    break;
                case 6:
                    System.out.println();
                    deteleAllGrade();
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

