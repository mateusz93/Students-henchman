package edu.p.lodz.pl.studentshenchman.constants;

/**
 * Created by Michał on 2016-10-05.
 */
public abstract class Constants {

	public static final String DATE_FORMAT = "yyyy\'-\'MM\'-\'dd\'T\'HH\':\'mm\':\'ss";


	public static final String PROTOCOL = "http";
	public static final String HOST = "localhost";
	public static final int PORT = 8080;

	public static final int READ_TIMEOUT = 30;
	public static final int CONNECTION_TIMEOUT = 30;
	public static final int WRITE_TIMEOUT = 30;

	//public static final String BASE_SERVER_URL = PROTOCOL + "://" + HOST + ":" + PORT + "/mobile";
	public static final String BASE_SERVER_URL = "https://query.yahooapis.com/";

}
