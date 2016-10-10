package edu.p.lodz.pl.studentshenchman.workers.utils;

/**
 * Created by Michał on 2016-10-08.
 */
public class ResponseError {

    private WorkerResponseCode code;
    private String message;
    private Throwable throwable;

    public ResponseError() {
    }

    public ResponseError(WorkerResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseError(WorkerResponseCode code, String message, Throwable throwable) {
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }

    public WorkerResponseCode getCode() {
        return code;
    }

    public void setCode(WorkerResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "code=" + code.getResponseCode() +
                ", message='" + message + '\'' +
                '}';
    }
}
