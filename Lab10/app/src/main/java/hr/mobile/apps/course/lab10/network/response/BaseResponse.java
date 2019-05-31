package hr.mobile.apps.course.lab10.network.response;

public class BaseResponse<T> {

    private boolean success;
    private T response;

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }
}
