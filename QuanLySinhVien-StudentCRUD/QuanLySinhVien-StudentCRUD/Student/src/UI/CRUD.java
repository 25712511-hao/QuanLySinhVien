package UI;

import Entity.Student;
import Control.StudentBusinessLogic;
import Control.UpdateSelection;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.Grade;
import java.util.List;

public class CRUD {
    Scanner scan = new Scanner(System.in);
    StudentBusinessLogic service = new StudentBusinessLogic();
    DataInput input = new DataInput(service.getStorage());

    public void create() {
        boolean again = false;
        do {
            again = false;

            String name = input.setNameInput();
            String id = input.setIDInput();
            int year = input.setYearInput();
            String schoolClass = input.setSchoolClassInput();
            String email = input.setEmailInput();
            int intakeNumber = input.setIntakeNumberInput();

            boolean sucess = service.saveData(name, id, year, schoolClass, email, intakeNumber);
            if (sucess) {
                System.out.println("Thêm thành công");
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
                System.out.println("Khônt tìm thấy sinh viên");
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
                        System.out.println((i + 1) + "." + options[i]);
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
            System.out.println("Mời lựa chọn (Nhập số phía trước các lựa chọn):\n1.Nhập thông tin\n2.In thông tin\n3.In toàn bộ danh sách\n4.Cập nhật thông tin\n5.Xóa thông tin\n6.Xóa toàn bộ thông tin của 1 sinh viên\nNhấn 0 để thoát");
            int option = service.checkOption(scan.nextLine());
            switch (option) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    System.out.println(readAll());
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    deteleAllInfo();
                    break;
                case 7:
                    addGradeUI();
                    break;
                case 8:
                    readGradeUI();
                    break;
                case 0:
                    again = false;
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại");
                    break;
            }
        }while (again);
    }

    public void addGradeUI() {
        System.out.print("Nhập MSSV cần nhập điểm: ");
        String id = scan.nextLine();
        Student sv = service.getStudentById(id);

        if (sv == null) {
            System.out.println("Không tìm thấy sinh viên có MSSV: " + id);
            return;
        }

        System.out.println("Đang nhập điểm cho sinh viên: " + sv.getName());
        System.out.print("Nhập mã môn học: ");
        String subjectId = scan.nextLine();

        System.out.print("Nhập điểm Chuyên cần: ");
        double cc = Double.parseDouble(scan.nextLine());

        System.out.print("Nhập điểm Giữa kỳ: ");
        double gk = Double.parseDouble(scan.nextLine());

        System.out.print("Nhập điểm Cuối kỳ: ");
        double ck = Double.parseDouble(scan.nextLine());

        boolean success = service.addGradeForStudent(id, subjectId, cc, gk, ck);
        if (success) {
            System.out.println("Thêm điểm thành công!");
        } else {
            System.out.println("Thêm điểm thất bại!");
        }
    }

    public void readGradeUI() {
        System.out.print("Nhập MSSV cần xem bảng điểm: ");
        String id = scan.nextLine();
        Student sv = service.getStudentById(id);

        if (sv == null) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }

        List<Grade> grades = service.getGradesByStudentId(id);
        System.out.println("\n========== BẢNG ĐIỂM SỐ ==========");
        System.out.println("Sinh viên: " + sv.getName() + " | MSSV: " + sv.getId() + " | Lớp: " + sv.getSchoolClass());

        if (grades == null || grades.isEmpty()) {
            System.out.println("Sinh viên này chưa có điểm môn nào!");
        } else {
            for (Grade g : grades) {
                System.out.printf("Môn: %-8s | CC: %-4.1f | GK: %-4.1f | CK: %-4.1f | Tổng: %-4.2f\n",
                        g.getSubjectId(), g.getScoreCc(), g.getScoreGk(), g.getScoreCk(), g.caculTotalScore());
            }
        }
    }


}

