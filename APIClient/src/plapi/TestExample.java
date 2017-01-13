package plapi;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

public class TestExample {

	public static void main(String[] args) {
		try {
			System.out.println("Creating a PLAPIClient object...");
			
			/* Initializing a new PLAPIClient object */
			PLAPIClient client = new PLAPIClient("https://secure.petro-logistics.com/api/v2/aggregatemovementsdata", "testuser_http_CuH68Omfx17R", "X9PV5EmJPr88lEyjD2I2IE26b9ElQCX0", "37rspm6j39td23nh0o2v0h78", "P0iwW39qaMvTjFRdcmsiKmD9OxGEquHNXapwbSQr8gbuV2ssqjbt0Vy7Yelyi4C1");
			
			System.out.println("Executing the query...");
			
			/* Executing the request and storing the result in a variable */
			JSONObject obj = client.execute("Angola_Test_Data");
			
			/* Print out the result if the request was successful otherwise print "FAIL" */
			System.out.println((obj == null) ? "FAIL" : obj.toString(3));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
