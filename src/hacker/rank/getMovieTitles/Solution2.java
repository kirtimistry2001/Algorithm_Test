package hacker.rank.getMovieTitles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Solution2 {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
   //     BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
    /*    String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }*/
        
        res = getMovieTitles("spiderman");//(_substr);
        for(int res_i=0; res_i < res.length; res_i++) {
        	System.out.println(String.valueOf(res[res_i]));
//            bw.write(String.valueOf(res[res_i]));
//            bw.newLine();
        }
        
       // bw.close();
    }
    

    static String[] getMovieTitles(String substr) {
    	 SortedSet set = new TreeSet(); 
        String urlStr = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;
        String s;
        try {
            JSONParser parser = new JSONParser();
            s= readJsonFromURL(urlStr);
            JSONObject jsonObj = (JSONObject) parser.parse(s);
            long total_pages = (Long) jsonObj.get("total");
            set.addAll(getData(jsonObj));
            
            for(int i = 2 ;i<=total_pages ; i++) {
                urlStr = urlStr+"&page="+i;
                s= readJsonFromURL(urlStr);
                jsonObj = (JSONObject) parser.parse(s);
                set.addAll(getData(jsonObj));
            }
        } catch(IOException |ParseException e) {
            e.printStackTrace();
        }

        
        
        String[] array = (String[]) set.toArray(new String[0]);
       
        return array;
    }

    
    private static List<String> getData(JSONObject jsonObj ) {
        List<String> list = new ArrayList<String>();  
        JSONArray jsonArray = (JSONArray) jsonObj.get("data");
        for(int i=0 ; i<jsonArray.size() ;  i++) {
            Object obj = jsonArray.get(i);
            if(obj instanceof JSONObject) {
                JSONObject data_obj = (JSONObject) obj;
                String title = (String) data_obj.get("Title");
                list.add(title);
            }
        }
        
        return list;
    
    }
    
    private static String readJsonFromURL(String url) throws IOException{
        InputStream is = new URL(url).openStream();
        String jsonText= null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while((cp = rd.read()) != -1) {
                sb.append((char)cp);
            }
            jsonText = sb.toString();
        } finally {
            is.close();
        }
        return jsonText;
    }

}
