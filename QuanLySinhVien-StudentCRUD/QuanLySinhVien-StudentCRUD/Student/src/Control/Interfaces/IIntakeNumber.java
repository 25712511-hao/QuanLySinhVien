package Control.Interfaces;

import Control.CheckedResult;

public interface IIntakeNumber {
    public default CheckedResult checkIntakeNumber(String intakeNumber) {
        try {
            if (intakeNumber == null || intakeNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Khóa không được để trống");
            } else {
                for (int i = 0; i < intakeNumber.length(); i++) {
                    char c = intakeNumber.charAt(i);
                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("Khóa chỉ được chứa số");
                    }
                }
                int intake = Integer.parseInt(intakeNumber);
                if (intake < 0) {
                    throw new IllegalArgumentException("Khóa không hợp lệ");
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
