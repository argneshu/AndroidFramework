package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map.Entry;

import org.json.JSONObject;

public class RestClient {

	public static final int RETURN_RESPONSE_CODE = 1;
	public static final int RETURN_JSON_STRING = 2;
	public static boolean restClient_Flag = true;
	static URLConnection conn = null;
	static HttpURLConnection httpConn = null;

	// constructor
	public RestClient() {

	}

	public static Object getJSONFromParamsObject(ParamObject obj, int returnType) throws IOException {

		InputStream in = null;
		JSONObject jObj = null;
		String json = "";
		// Making HTTP request
		try {

			switch (returnType) {
			case RETURN_RESPONSE_CODE:
				return OpenHttpConnection(obj, returnType);
			}
			in = (InputStream) OpenHttpConnection(obj, returnType);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			in.close();
			json = sb.toString();
			// System.out.println(json);
		} catch (Exception e) {
			// Log.e("Buffer Error", "Error converting result " + e.toString());
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return json;

	}

	private static Object OpenHttpConnection(ParamObject params, int returnType) throws IOException {
		InputStream in = null;

		// Log.d("palval", "OpenHttpConnection");

		int response = -1;

		URL url = new URL(params.getUrl());

		conn = url.openConnection();

		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try {

			httpConn = (HttpURLConnection) conn;
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setRequestMethod(params.getMethodType());

			for (Entry<String, String> entry : params.headers.entrySet()) {
				httpConn.setRequestProperty(entry.getKey(), entry.getValue());
			}

			if (restClient_Flag) {
				httpConn.setRequestProperty("Accept", "application/json");
				httpConn.setRequestProperty("Content-type", "application/json");
			} else {
				httpConn.setRequestProperty("Accept", "application/x-www-form-urlencoded");
				httpConn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			}

			if ("POST".equals(params.methodType) || "PUT".equals(params.methodType)) {

				String payload = params.getPayload();

				OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream(), "UTF-8");
				writer.write(payload);
				writer.close();
			} else {

			}
			httpConn.connect();
			int responseCode = httpConn.getResponseCode();
			System.out.println(responseCode);
			switch (returnType) {
			case RETURN_RESPONSE_CODE:
				return responseCode;
			}

			in = httpConn.getInputStream();

		}

		catch (Exception ex) {
			ex.printStackTrace();

		}
		return in;

	}

	public static int getResponseCode() throws IOException {
		return httpConn.getResponseCode();
	}

}
