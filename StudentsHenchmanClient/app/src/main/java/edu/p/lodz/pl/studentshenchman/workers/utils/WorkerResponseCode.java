package edu.p.lodz.pl.studentshenchman.workers.utils;

/**
 * Created by Michał on 2016-10-05.
 */
public enum WorkerResponseCode {
    OK(200), NO_CONTENT(201), BAD_REQUEST(400), NOT_FOUND(404), TIMEOUT(408), SERVER_ERROR(500);

    private final int responseCode;

    WorkerResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
