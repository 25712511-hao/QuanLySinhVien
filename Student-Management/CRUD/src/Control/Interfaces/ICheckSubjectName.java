package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckSubjectName {
    public default CheckedResult checkSubjectName(String subjectName) {
        try {
            if ( subjectName == null || subjectName.trim().isEmpty()) {
                throw new IllegalArgumentException("Tên môn không được để trống");
            }
            else {
                    char[] character = subjectName.toCharArray();
                for (char c : character) {
                    if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                        throw new IllegalArgumentException("Tên môn không được chứa kí tự khác chữ cái");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
