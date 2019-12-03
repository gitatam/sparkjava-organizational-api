package exc;

public class ApiErrorException extends RuntimeException {
    private final int status;

    public ApiErrorException(int statusCode, String msg) {
        super(msg);
        this.status = statusCode;
    }

    public int getStatus() {
        return status;
    }
}
