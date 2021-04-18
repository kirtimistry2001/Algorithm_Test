package hacker.rank.profitTarget;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
/*
 * 
 7
6
6
3
9
3
5
1
12
 */
    	   List<Integer> stocksProfit = Arrays.asList(6,6,3,9,3,5,1);
  //      int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

      
/*
        for (int i = 0; i < stocksProfitCount; i++) {
            int stocksProfitItem = Integer.parseInt(bufferedReader.readLine().trim());
            stocksProfit.add(stocksProfitItem);
        }
*/
        long target = 12;//Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.stockPairs(stocksProfit, target);

        System.out.println("result:"+ result);
        
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */

    public static int stockPairs(List<Integer> stocksProfit, long target) {
		
    	//remove duplicate
/*    	Set<Integer> set = new HashSet<Integer>(stocksProfit);
    	
    	List<Integer> list = new ArrayList<Integer>(set);*/
    	int result =0;
    	if (stocksProfit == null || stocksProfit.size() < 2 || target < 1)  return 0;
    		
        //map values to indexes
        final Map<Integer, Boolean> indexMap = new HashMap<>();
        List<Integer> nList = new ArrayList<Integer>();
        for (int i = 0; i < stocksProfit.size(); i++) {
            int needed = (int) (target - stocksProfit.get(i));
            /*if (indexMap.get(needed) != null && indexMap.get(needed) == false) {
            	result++;
            	indexMap.put(needed, true);
            	indexMap.put(stocksProfit.get(i), true);
            }

            indexMap.put(stocksProfit.get(i), false);*/
            if(nList!= null && nList.size() > 0 && nList.contains(needed)) {
            	result++;
            	
            }
            nList.add(needed);
        }

        //none found
        return result;

    	
  
    }
    
    /*// 13/15 testcase pass
     
    public static int stockPairs(List<Integer> stocksProfit, long target) {
     //remove duplicate
       Set<Integer> set = new HashSet<Integer>(stocksProfit);
        int result =0;
        List<Integer> list = new ArrayList<Integer>(set);
        
        if (list == null || list.size() < 2 || target < 1) 
            {
            return 0;
            }
        //map values to indexes
        final Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int needed = (int) (target - list.get(i));
            if (indexMap.get(needed) != null) {
                result++;
            }

            indexMap.put(list.get(i), i);
        }

        //none found
        return result;

    }
     */

}
