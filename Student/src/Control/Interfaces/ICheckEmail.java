package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckEmail {
    public default CheckedResult chekEmail(String email) {
        try {
            if ( email == null || email.trim().isEmpty()) {
                throw new IllegalArgumentException("Email không được để trống");
            }
            else {
                char[] character = email.toCharArray();
                    for (char c : character) {
                        if (!Character.isLetter(c) && !Character.isDigit(c) && c != '.') {
                            throw new IllegalArgumentException("Email chỉ được chứa chữ cái và số");
                        }
                    }
                }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
