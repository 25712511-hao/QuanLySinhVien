package Control.Interfaces;

import Control.CheckedResult;

public interface ICheckScore {
    public default CheckedResult checkScore(String score) {
        try {
            if (score == null || score.trim().isEmpty()) {
                throw new IllegalArgumentException("Điểm không được để trống");
            }
                double validscore = Double.parseDouble(score);
                if (validscore < 0 || validscore >10) {
                    throw new IllegalArgumentException("điểm không hợp lệ");
                }
        }catch (NumberFormatException e) {
            return new CheckedResult(false, "Điểm chỉ được chứa số (VD: 8 hoặc 8.5)!");
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
