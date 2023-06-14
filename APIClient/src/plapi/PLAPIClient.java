// Copyright (c) 2023 Petro-Logistics S.A., All rights reserved.

// This work is licensed under the terms of the MIT license.  
// For a copy, see <https://opensource.org/licenses/MIT>.

package plapi;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 * @author Tadej Gasparovic
 * @version 1.0
 * **/
public class PLAPIClient {

	/* API_URL */
	private URL API_URL;
	
	/*POST DATA*/
	private String API_KEY;
	private String API_HASH;
	private static final String FORMAT = "json";
	private static final String CSV_WITH_HEADERS = "1";
	
	/* HTTP AUTH */
	private String API_USER;
	private String API_PASSWORD;
	
	public PLAPIClient(String API_URL, String API_USER, String API_PASSWORD, String API_KEY, String API_HASH) throws MalformedURLException{
		this.API_URL = new URL(API_URL);
		this.API_USER = API_USER;
		this.API_PASSWORD = API_PASSWORD;
		this.API_KEY = API_KEY;
		this.API_HASH = API_HASH;
	}

	/**
	 * @param API_URL The URL object to be used for opening a URLConnection
	 * @param API_USER The HTTP user for Basic authentication
	 * @param API_PASSWORD The HTTP password for Basic authentication
	 * @param API_KEY The API key for API authentication
	 * @param API_HASH The API hash for API authentication
	 * **/
	public PLAPIClient(URL API_URL, String API_USER, String API_PASSWORD, String API_KEY, String API_HASH) throws MalformedURLException{
		this.API_URL = API_URL;
		this.API_USER = API_USER;
		this.API_PASSWORD = API_PASSWORD;
		this.API_KEY = API_KEY;
		this.API_HASH = API_HASH;
	}
	
	/**
	 * This method executes the query.
	 * @param query_name The query name to be used when building the POST data
	 * @return JOSNObject created from the raw data or null if the request failed.
	 * **/
	public JSONObject execute(String query_name) throws IOException{		
		String raw_data = post(query_name);
		
		if(raw_data == null){
			return null;
		}
		
		JSONObject obj = new JSONObject(raw_data);
		if(obj.getJSONObject("envelope").getJSONArray("header").getJSONArray(0).getString(1).equalsIgnoreCase("SUCCESS")){
			return obj;
		}
		
		return null;
	}
	
	/**
	 * This method performs the POST request to the API
	 * @param query_string The query name to be used when building the POST data
	 * @return The return data is the raw response from the API (null if there is an error)
	 * **/
	private String post(String query_name) throws IOException{
		URLConnection conn = API_URL.openConnection();
		
		String post_data = build_post(query_name);
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((API_USER + ":" + API_PASSWORD).getBytes()));
		
		conn.setUseCaches(false);
		
		if(conn instanceof HttpURLConnection){
			HttpURLConnection http = (HttpURLConnection)conn;
			
			http.setRequestMethod("POST");
			
		}else if(conn instanceof HttpsURLConnection){
			HttpsURLConnection https = (HttpsURLConnection)conn;
			
			https.setRequestMethod("POST");
			
		}else{
			return null;
		}
		
		StringReader string_reader = new StringReader(post_data);
		
		IOUtils.copy(string_reader, conn.getOutputStream(), Charset.forName("UTF-8"));
		
		StringWriter string_writer = new StringWriter();
		
		IOUtils.copy(conn.getInputStream(), string_writer, Charset.forName("UTF-8"));
		
		if(conn instanceof HttpURLConnection){
			HttpURLConnection http = (HttpURLConnection)conn;
			
			int response = http.getResponseCode();
			
			if(response != 200){
				return null;
			}
			
		}else if(conn instanceof HttpsURLConnection){
			HttpsURLConnection https = (HttpsURLConnection)conn;
			
			int response = https.getResponseCode();
			
			if(response != 200){
				return null;
			}
			
		}else{
			return null;
		}
		
		return string_writer.toString();
	}
	
	/** 
	 * This method builds the POST data for the given query name
	 * @param query_name The query name for which to build the POST data
	 * @return The URL encoded POST string
	 *  **/
	private String build_post(String query_name) throws UnsupportedEncodingException{
		StringBuilder post_data = new StringBuilder();
		
		post_data.append("api_key=");
		post_data.append(URLEncoder.encode(API_KEY, "UTF-8"));
		
		post_data.append("&api_hash=");
		post_data.append(URLEncoder.encode(API_HASH, "UTF-8"));
		
		post_data.append("&format=");
		post_data.append(URLEncoder.encode(FORMAT, "UTF-8"));
		
		post_data.append("&query_name=");
		post_data.append(URLEncoder.encode(query_name, "UTF-8"));
		
		post_data.append("&csv_with_headers=");
		post_data.append(URLEncoder.encode(CSV_WITH_HEADERS, "UTF-8"));
		
		return post_data.toString();
	}
	
	/* AUTOGENERATED GETTERS AND SETTERS */
	public URL getAPI_URL() {
		return API_URL;
	}

	public String getAPI_KEY() {
		return API_KEY;
	}

	public String getAPI_HASH() {
		return API_HASH;
	}

	public String getAPI_USER() {
		return API_USER;
	}

	public void setAPI_USER(String aPI_USER) {
		API_USER = aPI_USER;
	}

	public String getAPI_PASSWORD() {
		return API_PASSWORD;
	}

	public void setAPI_PASSWORD(String aPI_PASSWORD) {
		API_PASSWORD = aPI_PASSWORD;
	}

	public static String getFormat() {
		return FORMAT;
	}

	public static String getCsvWithHeaders() {
		return CSV_WITH_HEADERS;
	}

	public void setAPI_URL(URL aPI_URL) {
		API_URL = aPI_URL;
	}

	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}

	public void setAPI_HASH(String aPI_HASH) {
		API_HASH = aPI_HASH;
	}
}
