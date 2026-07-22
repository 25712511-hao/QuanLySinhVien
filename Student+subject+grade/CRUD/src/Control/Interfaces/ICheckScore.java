package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckScore {
    public default CheckedResult checkScore(String score) {
        try {
            if (score == null || score.trim().isEmpty()) {
                throw new IllegalArgumentException("Điểm không được để trống");
            } else {
                for (int i = 0; i < score.length(); i++) {
                    char c = score.charAt(i);
                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("Điểm chỉ được chứa số");
                    }
                }
                double validscore = Double.parseDouble(score);
                if (validscore < 0 || validscore >10) {
                    throw new IllegalArgumentException("điểm không hợp lệ");
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
