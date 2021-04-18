package hacker.rank.TransactionByAverageMonthlySpending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import org.json.simple.JSONObject;

public class Solution {
    public static void main(String[] args) {//throws IOException {
/*        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int uid = Integer.parseInt(bufferedReader.readLine().trim());

        String txnType = bufferedReader.readLine();

        String monthYear = bufferedReader.readLine();*/

        String monthYear;
		String txnType;
		int uid;
//		List<Integer> result = Result.getUserTransaction(uid, txnType, monthYear);

    /*    for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
class Result {

    /*
     * Complete the 'getUserTransaction' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER uid
     *  2. STRING txnType
     *  3. STRING monthYear
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?userId=
     */

    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
    	
/*    	URL url = new URL("http://example.com");
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	
    	Map<String, String> parameters = new HashMap<>();
    	parameters.put("param1", "val");

    	con.setDoOutput(true);
    	DataOutputStream out = new DataOutputStream(con.getOutputStream());
    	out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
    	out.flush();
    	out.close();
    	
    	con.setRequestProperty("Content-Type", "application/json");
    	
    	String contentType = con.getHeaderField("Content-Type");	
    	con.setConnectTimeout(5000);
    	con.setReadTimeout(5000);
    	
    	String cookiesHeader = con.getHeaderField("Set-Cookie");
    	List<HttpCookie> cookies = HttpCookie.parse(cookiesHeader);*/
    	
 /*   	String urlStr = "https://jsonmock.hackerrank.com/api/transactions/search?userId="+uid;
    			
    	URL url = new URL(urlStr);

    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	conn.setRequestMethod("GET");
    	conn.connect();

    	//Getting the response code
    	int responsecode = conn.getResponseCode();
    	
    	
    	if (responsecode != 200) {
    	    throw new RuntimeException("HttpResponseCode: " + responsecode);
    	} else {
    	  
    	    String inline = "";
    	    Scanner scanner = new Scanner(url.openStream());
    	  
    	   //Write all the JSON data into a string using a scanner
    	    while (scanner.hasNext()) {
    	       inline += scanner.nextLine();
    	    }
    	    
    	    //Close the scanner
    	    scanner.close();

    	    //Using the JSON simple library parse the string into a json object
    	    JSONParser parse = new JSONParser();
    	    JSONObject data_obj = (JSONObject) parse.parse(inline);

    	    //Get the required object from the above created object
    	    JSONObject obj = (JSONObject) data_obj.get("Global");

    	    //Get the required data using its key
    	    System.out.println(obj.get("TotalRecovered"));
    	}
    	*/
		return null;

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject json = new JSONObject(jsonText);
          return json;
        } finally {
          is.close();
        }
      }
}


