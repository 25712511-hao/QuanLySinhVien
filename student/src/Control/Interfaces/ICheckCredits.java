package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckCredits {
    public default CheckedResult checkCredits(String credits) {
        try {
            if (credits == null || credits.trim().isEmpty()) {
                throw new IllegalArgumentException("Số tín chỉ không được để trống");
            } else {
                for (int i = 0; i < credits.length(); i++) {
                    char c = credits.charAt(i);
                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("Số tín chỉ chỉ được chứa số");
                    }
                }
                int validCredits = Integer.parseInt(credits);
                if (validCredits <= 0) {
                    throw new IllegalArgumentException("điểm không hợp lệ");
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
