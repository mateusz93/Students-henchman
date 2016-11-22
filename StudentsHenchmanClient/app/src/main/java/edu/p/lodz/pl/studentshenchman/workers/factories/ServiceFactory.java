package edu.p.lodz.pl.studentshenchman.workers.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import edu.p.lodz.pl.studentshenchman.constants.Constants;
import edu.p.lodz.pl.studentshenchman.login.utils.LoginManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Michał on 2016-10-08.
 */
public class ServiceFactory {

	public static <T> T produceService(final Class<T> clazz, final boolean retryIfFailure) {
		final Retrofit.Builder builder = new Retrofit.Builder()
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create(getGson()))
				.client(getHttpClient(retryIfFailure))
				.baseUrl(Constants.BASE_SERVER_URL);


		T service = builder.build().create(clazz);

		return service;
	}

	private static Gson getGson() {
		Gson gson = new GsonBuilder()
				.setDateFormat(Constants.DATE_FORMAT)
				.registerTypeAdapterFactory(new ItemTypeAdapterFactory())
				.create();

		return gson;
	}

	private static OkHttpClient getHttpClient(final boolean retryIfFailure) {

		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		OkHttpClient.Builder builder = new OkHttpClient.Builder();

		builder.addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Interceptor.Chain chain) throws IOException {
				Request original = chain.request();

				Request request = original.newBuilder()
						.header("Accept", "application/json")
						.addHeader("Content-Type", "application/json")
						.addHeader("Authorization", "Basic bW9iaWxlOm1vYmlsZQ==") //dodana autoryzacja basic dla konta testowego mobile:mobile
						.addHeader("email", LoginManager.getInstance().getUserEmail())
						.method(original.method(), original.body())
						.build();

				return chain.proceed(request);
			}
		});

		builder.connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
				.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
				.retryOnConnectionFailure(retryIfFailure)
				.addInterceptor(httpLoggingInterceptor);

		return builder.build();
	}

	private static class ItemTypeAdapterFactory implements TypeAdapterFactory {

		@Override
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
			final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
			final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

			return new TypeAdapter<T>() {

				public void write(JsonWriter out, T value) throws IOException {
					delegate.write(out, value);
				}

				public T read(JsonReader in) throws IOException {

					JsonElement jsonElement = elementAdapter.read(in);
					if (jsonElement.isJsonObject()) {
						JsonObject jsonObject = jsonElement.getAsJsonObject();
						if (jsonObject.has("data") && (jsonObject.get("data").isJsonObject() || jsonObject.get("data").isJsonArray())) {
							jsonElement = jsonObject.get("data");
						}
					}

					return delegate.fromJsonTree(jsonElement);
				}
			}.nullSafe();
		}


	}
	//TODO zaimplementowac dynamiczne uzupelnianie headerow jezeli jest to mozliwe
}
