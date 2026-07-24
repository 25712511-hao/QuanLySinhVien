package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckIDSubject {
    public default CheckedResult checkIDSubject(String idSubject) {
        try {
            if ( idSubject == null || idSubject.trim().isEmpty()) {
                throw new IllegalArgumentException("Mã môn không được để trống");
            }
            else {
                    char[] character = idSubject.toCharArray();
                for (char c : character) {
                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("Mã môn chỉ được chứa số");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
