package hacker.rank.maximumRatingSum;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = new ArrayList<>();
//
//        for (int i = 0; i < arrCount; i++) {
//            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
//            arr.add(arrItem);
//        }
 	   List<Integer> arr = Arrays.asList(-1,-2,1,3);//(-6,6,-3,-9,3,5,1);

        long result = Result.maximumSum(arr);
        System.out.println("result: "+result);;
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

///https://www.youtube.com/watch?v=86CQq3pKSUw&t=454s
class Result {
//		//using Kadane's algorith

	
    /*
     * Complete the 'maximumSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

	public static long maximumSum(List<Integer> arr) {
		if(arr.isEmpty()) return 0;
		long max_current = arr.get(0);
		long max_global = max_current;
		for (int i=1; i<arr.size(); i++) {
			max_current = Math.max(arr.get(i), max_current+arr.get(i));
			if(max_current > max_global) {
				max_global = max_current;
			}
		}		
		return max_global;

	}


}
