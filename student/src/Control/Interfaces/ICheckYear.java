package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckYear {
    public default CheckedResult checkYear(String birthYear) {
        try {
            if (birthYear == null || birthYear.trim().isEmpty()) {
                throw new IllegalArgumentException("Năm sinh không được để trống");
            } else {
                for (int i = 0; i < birthYear.length(); i++) {
                    char c = birthYear.charAt(i);
                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("Năm sinh chỉ được chứa số");
                    }
                }
                int year = Integer.parseInt(birthYear);
                if (year < 1980 || year > 2026) {
                    throw new IllegalArgumentException("Năm sinh không hợp lệ");
                }
            }
            if (!birthYear.matches("\\d{4}")) {
                throw new IllegalArgumentException("Năm sinh phải gồm đúng 4 chữ số (Ví dụ: 2005)");
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
