package edu.p.lodz.pl.studentshenchman.workers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;

import edu.p.lodz.pl.studentshenchman.workers.utils.ResponseError;
import edu.p.lodz.pl.studentshenchman.workers.utils.WorkerResponseCode;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;

/**
 * Created by Michał on 2016-10-05.
 */
public abstract class AbstractWorker<T> implements Observer<T> {

    private static final String TAG = AbstractWorker.class.getName();

    public static final String WORKER_TYPE = "WORKER_TYPE";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";

    public abstract void sendResponse(Intent responseIntent);

    public abstract void run();

    public void runService() {
        run();
    }

    // tymczasowa obsluga bledow, trzeba zwracac bardziej czytelne bledy
    public void onError(Context context, Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            catchServerResponseError(context, new ResponseError(mapResponseCodeToResponseError(httpException.code()), httpException.response().message(), httpException));
        } else if (throwable instanceof SocketTimeoutException) {
            Toast.makeText(context, "Socket Timeout Exception", Toast.LENGTH_LONG).show();
        } else if (throwable instanceof IOException) {
            Toast.makeText(context, "Network conversion error", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
        }
        Log.i(TAG, throwable.toString());

    }

    private WorkerResponseCode mapResponseCodeToResponseError(int httpResponseCode) {
        switch (httpResponseCode) {
            case 400:
                return WorkerResponseCode.BAD_REQUEST;
            case 401:
                return WorkerResponseCode.UNAUTHORIZED;
            case 404:
                return WorkerResponseCode.NOT_FOUND;
            case 408:
                return WorkerResponseCode.TIMEOUT;
            case 414:
                return WorkerResponseCode.URI_TOO_LONG;
            case 415:
                return WorkerResponseCode.UNSUPPORTED_MEDIA_TYPE;
            case 429:
                return WorkerResponseCode.TOO_MANY_REQUESTS;
            case 500:
                return WorkerResponseCode.SERVER_ERROR;
            case 503:
                return WorkerResponseCode.SERVICE_UNAVAILABLE;
            default:
                return WorkerResponseCode.IDLE;
        }
    }

    private void catchServerResponseError(Context context, ResponseError responseError) {
        switch (responseError.getCode()) {
            case BAD_REQUEST:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case UNAUTHORIZED:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case NOT_FOUND:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case TIMEOUT:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case URI_TOO_LONG:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case UNSUPPORTED_MEDIA_TYPE:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case TOO_MANY_REQUESTS:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case SERVER_ERROR:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            case SERVICE_UNAVAILABLE:
                Toast.makeText(context, responseError.getCode() + " " + responseError.getMessage(), Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
        }
    }
}
