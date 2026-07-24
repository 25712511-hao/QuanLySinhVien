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

    public String getNotification() {
        return notification;
    }
}
