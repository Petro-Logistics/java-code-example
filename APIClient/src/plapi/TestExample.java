// Copyright (c) 2019 Petro-Logistics S.A., All rights reserved.

// This work is licensed under the terms of the MIT license.  
// For a copy, see <https://opensource.org/licenses/MIT>.

package plapi;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

public class TestExample {

	public static void main(String[] args) {
		try {
			System.out.println("Creating a PLAPIClient object...");
			
			/* Initializing a new PLAPIClient object */
			PLAPIClient client = new PLAPIClient("https://secure.petro-logistics.com/api/v3/aggregatemovementsdata", "testuser_http_kRQNk5878ezA", "F268DBvvPCBV83eT1vIeTpBGrJD604K2", "37rspm6j39td23nh0o2v0h78", "d1Npusz7BrVDauza7b7v5swgV20uiXQwiCG6nxiPseWRda6mTfJBeByKZsvp5sNX");
			
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
