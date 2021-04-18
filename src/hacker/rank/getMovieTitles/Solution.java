package hacker.rank.getMovieTitles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class Solution {

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
    	  List<String> set = new ArrayList<String>();  
        String urlStr = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;
        String s;
        try {
        	Gson gson = new Gson();
            s= readJsonFromURL(urlStr);
            JsonObject jobj = new Gson().fromJson(s, JsonObject.class);
            long total_pages = jobj.get("total").getAsLong();
            System.out.println("total_pages:"+total_pages);
            set.addAll(getData(jobj));
            
            for(int i = 2 ;i<=total_pages ; i++) {
                urlStr = urlStr+"&page="+i;
                s= readJsonFromURL(urlStr);
                jobj = new Gson().fromJson(s, JsonObject.class);
                set.addAll(getData(jobj));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        Collections.sort(set);
        String[] array = (String[]) set.toArray(new String[0]);
       
        return array;
    }

    
    private static Set<String> getData(JsonObject jsonObj ) {
       Set<String> list = new HashSet<String>();  
         JsonArray jsonArray = jsonObj.get("data").getAsJsonArray();
         
        for(int i=0 ; i<jsonArray.size() ;  i++) {
           JsonElement obj = jsonArray.get(i);
            if(obj instanceof JsonElement) {
            	JsonObject data_obj = (JsonObject) obj;
                String title =  data_obj.get("Title").getAsString();
                list.add(title);
            }
        }
        
        return list;
    
    }
    
    private static String readJsonFromURL(String url) throws IOException{
        InputStream is = new URL(url).openStream();
        String jsonText= null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
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
