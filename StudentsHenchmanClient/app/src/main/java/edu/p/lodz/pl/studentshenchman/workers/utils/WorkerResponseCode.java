package edu.p.lodz.pl.studentshenchman.workers.utils;

/**
 * Created by Michał on 2016-10-05.
 */
public enum WorkerResponseCode {
	// 2**
	OK(200), NO_CONTENT(201),
	// 4**
	BAD_REQUEST(400), UNAUTHORIZED(401), NOT_FOUND(404), TIMEOUT(408), URI_TOO_LONG(414), UNSUPPORTED_MEDIA_TYPE(415), TOO_MANY_REQUESTS(429),
	// 5**
	SERVER_ERROR(500), SERVICE_UNAVAILABLE(503),
	// idle
	IDLE(0);

	private final int responseCode;

	WorkerResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public int getResponseCode() {
		return responseCode;
	}
}
