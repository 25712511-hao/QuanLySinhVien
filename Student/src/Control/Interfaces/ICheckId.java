package Control.Interfaces;
import Control.CheckStorage;
import Control.CheckedResult;
import Repository.StudentRepository;
public interface ICheckId {
    public default CheckedResult checkId(String id, StudentRepository repository) {
        try {
            if ( id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("MSSV không được để trống");
            }
            else {
                char[] character = id.toCharArray();
                if (character.length != 8) {
                    throw new IllegalArgumentException("MSSV phải chứa đủ 8 kí tự");
                }
                else {
                    CheckStorage checkSto = new CheckStorage(repository);
                    if (checkSto.found(id) != null) {
                        throw new IllegalArgumentException("Sinh viên có mã số này đã có trong danh sách");
                    } else {
                        for (char c : character) {
                            if (!Character.isDigit(c)) {
                                throw new IllegalArgumentException("MSSV chỉ được chứa số");
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            return new CheckedResult(false, e.getMessage());
        }
        return new CheckedResult(true, "Nhập Thành công");
    }
}
