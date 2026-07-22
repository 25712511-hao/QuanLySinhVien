package Control;

public class CheckedResult {
    private boolean result;
    private String notification;

    public CheckedResult(boolean result, String notification) {
        this.result = result;
        this.notification = notification;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String finalResult(boolean result, String notification){
        if (!result){
            return notification;
        }
        else{
            return "Nhập thành công";
        }
    }
}
