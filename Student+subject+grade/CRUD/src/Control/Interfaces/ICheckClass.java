package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckClass {
    public default CheckedResult checkSchoolClass(String schoolClass) {
    try {
        if ( schoolClass == null || schoolClass.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên lớp học không được để trống");
        }
        else {
            char[] character = schoolClass.toCharArray();
            if (character.length < 7) {
                throw new IllegalArgumentException("Tên lớp học phải chứa ít nhất 7 kí tự");
            } else {
                String classOfStudent = schoolClass.toUpperCase();
                String universityLevel = classOfStudent.substring(0, 2);
                if (!universityLevel.equalsIgnoreCase("DH")) {
                    throw new IllegalArgumentException("Bậc học không hợp lệ");
                }
                int findNumber = -1;
                for (int i = 2; i < classOfStudent.length() - 1; i++) {
                    if (Character.isDigit(classOfStudent.charAt(i)) && Character.isDigit(classOfStudent.charAt(i + 1))) {
                        findNumber = i;
                        break;
                    }
                }
                if (findNumber == -1) {
                    throw new IllegalArgumentException("Số lớp không hợp lệ");
                }
                if (!Character.isLetter(classOfStudent.charAt(findNumber + 2))) {
                    throw new IllegalArgumentException("Số lớp không hợp lệ");
                }
                if (classOfStudent.charAt(classOfStudent.length() - 1) != '0' && classOfStudent.charAt(classOfStudent.length() - 1) != '1') {
                    throw new IllegalArgumentException("Hệ đào tạo không hợp lệ");
                }
            }
        }
    } catch (IllegalArgumentException e) {
        return new CheckedResult(false, e.getMessage());
    }
    return new CheckedResult(true, "Nhập Thành công");
}
}
