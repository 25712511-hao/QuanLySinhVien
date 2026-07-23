package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckName {
    public default CheckedResult checkName(String name) {
        try {
            if ( name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Tên không được để trống");
            }
            else {
                    char[] character = name.toCharArray();
                for (char c : character) {
                    if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                        throw new IllegalArgumentException("Tên không được chứa kí tự khác chữ cái");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
