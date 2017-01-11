package plapi;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

public class TestExample {

	public static void main(String[] args) {
		try {
			/* Initializing a new PLAPIClient object */
			PLAPIClient client = new PLAPIClient("https://secure.petro-logistics.com/api/v2/movementsdata", "stacey_http_7zz7lQ28eWFK", "6AsLJVuKpx4miX47151JK82BvMXKNR2S", "o79z9ff1or702t09tr6d48xs", "qEbl7HsOasyzLoqrdLZF6Na9aqd9xJ2n7Zkdz92jekk7LknSxD3QAfguLnWZjpFU");
			
			/* Executing the request and storing the result in a variable */
			JSONObject obj = client.execute("Nigeria_Oct_2016_p30");
			
			/* Print out the result if the request was successful otherwise print "FAIL" */
			System.out.println((obj == null) ? "FAIL" : obj.toString(3));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
