package UI;

import Entity.Student;
import Control.StudentBusinessLogic;
import Control.UpdateSelection;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUD {
    Scanner scan = new Scanner(System.in);
    StudentBusinessLogic service;
    StudentDataInput input;

    public StudentCRUD(StudentBusinessLogic service) {
        this.service = service;
        this.input = new StudentDataInput(service.getStorage());
    }
    private String toDisplayLabel(UpdateSelection select) {
        return switch (select) {
            case NAME -> "Tên sinh viên";
            case ID -> "Mã số sinh viên";
            case BIRTHYEAR -> "Năm sinh của sinh viên";
            case SCHOOLCLASS -> "Lớp của sinh viên";
        };
    }
    public void create() {
        boolean again = false;
        do {
            String name = input.setNameInput();
            String id = input.setIDInput();
            int year = input.setYearInput();
            String schoolClass = input.setSchoolClassInput();

            boolean sucess = service.saveData(name, id, year, schoolClass);
            if (sucess) {
                System.out.println("\nThêm thành công");
            } else {
                System.out.println("Trùng MSSV\nThêm thất bại");
                again = true;
            }
        } while (again);
    }

    public void read() {
        boolean again = false;
        do {
            again = false;
            System.out.println("Chọn sinh viên cần in ra thông tin (Nhập MSSV): ");
            String id = scan.nextLine();
            Student sv = service.getStudentById(id);

            if (sv == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = service.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                    break;
                    default:
                        again = false;
                }
            } else {
                System.out.println(sv);
            }
        } while (again);
    }

    public ArrayList<Student> readAll() {
        return service.getAllStudent();
    }

    public void update() {
        boolean again = false;
        do {
            readAll();
            again = false;
            System.out.println("Chọn sinh viên cần cập nhật (nhập MSSV): ");
            String idStudent = scan.nextLine();
            Student sv = service.getStudentById(idStudent);
            if (sv == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = service.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                System.out.println(sv);
                UpdateSelection[] options = UpdateSelection.values();
                boolean checkOption;
                int n = -1;
                do {
                    System.out.println("Mời lựa chọn thông tin cần cập nhật: ");
                    for (int i = 0; i < options.length; i++) {
                        System.out.println((i + 1) + "." + toDisplayLabel(options[i]));
                    }
                    n = scan.nextInt();
                    scan.nextLine();
                   checkOption = service.validOption(n);
                }while (!checkOption);
                UpdateSelection select = options[n - 1];

                System.out.println(" Nhập thông tin cần cập nhật:");
                String newValue = scan.nextLine();
                boolean sucess = service.updateStudentInfo(idStudent, select, newValue);
                if (!sucess) {
                    System.out.println("Cập nhật thất bại\nThông tin không hợp lệ hoặc lựa chọn không tồn tại");
                } else {
                    System.out.println("Cập nhật thành công");
                }
            }
        } while (again);
    }

    public void delete() {
        boolean again = false;
        do {
            readAll();
            again = false;
            System.out.println("Chọn sinh viên cần xóa (nhập MSSV): ");
            String idStudent = scan.nextLine();
            Student sv = service.getStudentById(idStudent);
            if (sv == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = service.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                UpdateSelection[] options = UpdateSelection.values();
                System.out.println("Mời lựa chọn thông tin cần xóa: ");
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + "." + options[i]);
                }

                UpdateSelection select = options[scan.nextInt() - 1];
                scan.nextLine();

                boolean sucess = service.deleteStudentInfo(idStudent, select);
                if (!sucess) {
                    System.out.println("Xóa thất bại");
                } else {
                    System.out.println("Xóa thành công");
                }
            }
        } while (again);
    }
    public void deteleAllInfo(){
        boolean again = false;
        do {
            readAll();
            again = false;
            System.out.println("Chọn sinh viên cần xóa (nhập MSSV): ");
            String idStudent = scan.nextLine();
            Student sv = service.getStudentById(idStudent);
            if (sv == null) {
                System.out.println("Không tìm thấy sinh viên");
                System.out.println("Nhập 1 để nhập lại\nNhấn phím bất kì khác phím số 1 để hủy");
                int cancelOption = service.checkOption(scan.nextLine());
                switch (cancelOption){
                    case 1 : again = true;
                        break;
                    default:
                        again = false;
                }
            } else {
                System.out.println("Xóa thành công");
                service.deteleAllInfo(idStudent);
            }
        }while (again);
    }

    public void seclectCRUD() {
        boolean again = true;
        do {
            System.out.println();
            System.out.println("===Quản lý sinh viên===");
            System.out.println("Mời lựa chọn (Nhập số phía trước các lựa chọn):\n1.Nhập thông tin\n2.In thông tin\n3.In toàn bộ danh sách\n4.Cập nhật thông tin\n5.Xóa thông tin\n6.Xóa toàn bộ thông tin của 1 sinh viên\nNhấn 0 để thoát");
            int option = service.checkOption(scan.nextLine());
            switch (option) {
                case 1:
                    System.out.println();
                    create();
                    break;
                case 2:
                    System.out.println();
                    read();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(readAll());
                    break;
                case 4:
                    System.out.println();
                    update();
                    break;
                case 5:
                    System.out.println();
                    delete();
                    break;
                case 6:
                    System.out.println();
                    deteleAllInfo();
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

