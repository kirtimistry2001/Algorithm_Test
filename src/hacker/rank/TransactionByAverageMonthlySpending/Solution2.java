package hacker.rank.TransactionByAverageMonthlySpending;

//using json-20210307.jar



public class Solution2 {
	public static void main(String[] args) { 
		// throws IOException {
	}
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

//		String monthYear = "02-2019";
//		String txnType = "debit";
//		int uid = 4;
//		List<Integer> result = Result.getUserTransaction(uid, txnType, monthYear);
//		System.out.println("result:" + result);
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
//	}
}

//class Result {

	/*
	 * Complete the 'getUserTransaction' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER uid 2. STRING txnType 3. STRING monthYear
	 *
	 * https://jsonmock.hackerrank.com/api/transactions/search?userId=
	 */

//	public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
//		List<Integer> list = new ArrayList();
//		Map<Integer, Double> map = new HashMap<Integer, Double>();
//		String urlStr = "https://jsonmock.hackerrank.com/api/transactions/search?userId=" + uid;
//		try {
//			JSONObject jsonObj = readJsonFromUrl(urlStr);
//			// get total pages
//			int total_pages = jsonObj.getInt("total");
//			map.putAll(getData(jsonObj, txnType, monthYear));
//			for (int i = 2; i <= total_pages; i++) {
//				System.out.println("----------page: "+i);
//				String url_page_str = urlStr + "&page=" + i;
//				jsonObj = readJsonFromUrl(url_page_str);
//				map.putAll(getData(jsonObj, txnType, monthYear));
//			}
//			TreeMap<Integer, Double> sorted = new TreeMap<>();
//			sorted.putAll(map);
//			double total_amount = 0  ;
//			for (Double value : sorted.values()) {
//				total_amount+=value;
//			    System.out.println("Value = " + value);
//			}
//			if (total_amount != 0) {
//				double avg = total_amount/sorted.size();
//				System.out.println("avg = " + avg);
//
//				for (Map.Entry<Integer, Double> entry : sorted.entrySet()) {
//					if (entry.getValue() > avg) {
//						list.add(entry.getKey());
//					}
//				}
//				Collections.sort(list);
//			}
//
//		} catch (JSONException | IOException e) {
//			e.printStackTrace();
//		}
//		return list;
//
//	}
//
//	private static Map<Integer, Double> getData(JSONObject jsonObj, String txnType, String monthYear) {
//		Map<Integer, Double> map = new HashMap<Integer, Double>();
//		JSONArray jsonArray = jsonObj.getJSONArray("data");
//		for (int i = 0; i < jsonArray.length(); i++) {
//			Object obj = jsonArray.get(i);
//			if (obj instanceof JSONObject) {
//				JSONObject data_obj = (JSONObject) obj;
//				String obj_txnType = data_obj.getString("txnType");
//				System.out.println("obj_txnType: "+obj_txnType +"\t txnType: "+txnType);
//				if (obj_txnType.equalsIgnoreCase(txnType)) {
//					Integer id = data_obj.getInt("id");
//					String amount = data_obj.getString("amount");
////					System.out.println("id:" + id + "amount: " + amount);
//					Integer timestamp = data_obj.getInt("timestamp");
//					Timestamp stamp = new Timestamp(timestamp);
//					Date date = new Date(stamp.getTime());
//					//System.out.println("date:" + date);
//					SimpleDateFormat formatter = new SimpleDateFormat("MM-YYYY");
//					String month_year = formatter.format(date);
//					System.out.println("month_year:" + month_year + "\tmonthYear: " + monthYear);
//
//					if (month_year.equalsIgnoreCase(monthYear)) {
//						System.out.println("month_year:" + month_year + "monthYear: " + monthYear);
//
//						NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
//						try {
//							Double amt = (Double) numberFormat.parse(data_obj.getString("amount"));
//							System.out.println("id:" +data_obj.getInt("id") + " value: "+amt);
//							map.put(data_obj.getInt("id"), amt); 
//						} catch (ParseException exception) {
//							System.out.println("Parse Exception1: " + exception);
//						}
//					
//						(data_obj).keys().forEachRemaining(key -> {
//							Object value = (data_obj).get(key);
//						//	System.out.println("Key: " + key + " value: " + value);
//
//						});
//					}
//				}
//			}
//		}
//		return map;
//	}
//
//	private static String readAll(Reader rd) throws IOException {
//		StringBuilder sb = new StringBuilder();
//		int cp;
//		while ((cp = rd.read()) != -1) {
//			sb.append((char) cp);
//		}
//		return sb.toString();
//	}
//
//	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
//		InputStream is = new URL(url).openStream();
//		try {
//			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//			String jsonText = readAll(rd);
//			JSONObject json = new JSONObject(jsonText);
//			return json;
//		} finally {
//			is.close();
//		}
//	}
//}
