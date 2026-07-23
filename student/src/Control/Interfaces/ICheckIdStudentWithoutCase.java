package Control.Interfaces;
import Control.CheckedResult;
public interface ICheckIdStudentWithoutCase {
    public default CheckedResult checkId(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("MSSV không được để trống");
            } else {
                char[] character = id.toCharArray();
                if (character.length != 8) {
                    throw new IllegalArgumentException("MSSV phải chứa đủ 8 kí tự");
                } else {
                    for (char c : character) {
                        if (!Character.isDigit(c)) {
                            throw new IllegalArgumentException("MSSV chỉ được chứa số");
                        }
                    }
                }
            }
        }catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
