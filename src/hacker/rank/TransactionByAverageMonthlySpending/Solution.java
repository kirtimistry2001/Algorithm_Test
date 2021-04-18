package hacker.rank.TransactionByAverageMonthlySpending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Solution {
	public static void main(String[] args) {// throws IOException {
		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		 * 
		 * int uid = Integer.parseInt(bufferedReader.readLine().trim());
		 * 
		 * String txnType = bufferedReader.readLine();
		 * 
		 * String monthYear = bufferedReader.readLine();
		 */

		String monthYear = "02-2019";
		String txnType = "debit";
		int uid = 4;
		List<Integer> result = Result.getUserTransaction(uid, txnType, monthYear);
		System.out.println("result:" + result);
		/*
		 * for (int i = 0; i < result.size(); i++) {
		 * bufferedWriter.write(String.valueOf(result.get(i)));
		 * 
		 * if (i != result.size() - 1) { bufferedWriter.write("\n"); } }
		 * 
		 * bufferedWriter.newLine();
		 * 
		 * bufferedReader.close(); bufferedWriter.close();
		 */
	}
}

class Result {

	/*
	 * Complete the 'getUserTransaction' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER uid 2. STRING txnType 3. STRING monthYear
	 *
	 * https://jsonmock.hackerrank.com/api/transactions/search?userId=
	 */

	public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Long, Double> map = new HashMap<Long, Double>();
		String urlStr = "https://jsonmock.hackerrank.com/api/transactions/search?userId=" + uid;
		String s;
		JSONParser parser = new JSONParser();
		try {
			s = readJsonFromUrl(urlStr);
            JSONObject jsonObj = (JSONObject) parser.parse(s);
            long total_pages = (Long) jsonObj.get("total");
			map.putAll(getData(jsonObj, txnType, monthYear));

			for (int i = 2; i <= total_pages; i++) {
				//System.out.println("----------page: "+i);
				String url_page_str = urlStr + "&page=" + i;
				s = readJsonFromUrl(url_page_str);
				jsonObj = (JSONObject) parser.parse(s);
				map.putAll(getData(jsonObj, txnType, monthYear));
			}
			TreeMap<Long, Double> sorted = new TreeMap<>();
			sorted.putAll(map);
			double total_amount = 0  ;
			for (Double value : sorted.values()) {
				total_amount+=value;
			 //   System.out.println("Value = " + value);
			}
			if (total_amount != 0) {
				double avg = total_amount/sorted.size();
				//System.out.println("avg = " + avg);

				for (Map.Entry<Long, Double> entry : sorted.entrySet()) {
					if (entry.getValue() > avg) {
						list.add(entry.getKey().intValue());
					}
				}
				Collections.sort(list);
			}

		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return list;

	}

	private static Map<Long, Double> getData(JSONObject jsonObj, String txnType, String monthYear) {
		Map<Long, Double> map = new HashMap<Long, Double>();
		JSONArray jsonArray = (JSONArray) jsonObj.get("data");
		for (int i = 0; i < jsonArray.size(); i++) {
			Object obj = jsonArray.get(i);
			if (obj instanceof JSONObject) {
				JSONObject data_obj = (JSONObject) obj;
				String obj_txnType = (String) data_obj.get("txnType");
			//	System.out.println("obj_txnType: "+obj_txnType +"\t txnType: "+txnType);
				if (obj_txnType.equalsIgnoreCase(txnType)) {
					long id = (Long) data_obj.get("id");
					String amount = (String) data_obj.get("amount");
//					System.out.println("id:" + id + "amount: " + amount);
					long timestamp = (long) data_obj.get("timestamp");
					Timestamp stamp = new Timestamp(timestamp);
					Date date = new Date(stamp.getTime());
					//System.out.println("date:" + date);
					SimpleDateFormat formatter = new SimpleDateFormat("MM-YYYY");
					String month_year = formatter.format(date);
				//	System.out.println("month_year:" + month_year + "\tmonthYear: " + monthYear);

					if (month_year.equalsIgnoreCase(monthYear)) {
					//	System.out.println("month_year:" + month_year + "monthYear: " + monthYear);

						NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
						try {
							Double amt = (Double) numberFormat.parse((String) data_obj.get("amount"));
						//	System.out.println("id:" +data_obj.get("id") + " value: "+amt);
							map.put((Long) data_obj.get("id"), amt); 
						} catch (ParseException exception) {
							System.out.println("Parse Exception1: " + exception);
						}
					

					}
				}
			}
		}
		return map;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static String readJsonFromUrl(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		String jsonText=null;
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			jsonText = readAll(rd);
//			JSONObject json = new JSONObject(jsonText);
		
		} finally {
			is.close();
		}
		return jsonText;
	}
}
