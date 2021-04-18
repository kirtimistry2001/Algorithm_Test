package hacker.rank.buyingTickets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int ticketsCount = Integer.parseInt(bufferedReader.readLine().trim());
    /*
2
6
3
4
5
2
     */
    //    List<Integer> tickets = Arrays.asList(5,2,6,3,4,5);
    	   List<Integer> tickets = Arrays.asList(2, 6, 3, 4, 5);
//        for (int i = 0; i < ticketsCount; i++) {
//            int ticketsItem = Integer.parseInt(bufferedReader.readLine().trim());
//            tickets.add(ticketsItem);
//        }

        int p = 2;//Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.waitingTime(tickets, p);
        System.out.println("result:"+result);
       // bufferedWriter.write(String.valueOf(result));
      //  bufferedWriter.newLine();

    //    bufferedReader.close();
     //   bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'waitingTime' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY tickets
     *  2. INTEGER p
     */

    public static long waitingTime(List<Integer> tickets, int p) {
    	 Long count = 0L;
    	 final int size = tickets.size();
         boolean done = false;
         while (!done) {
             for (int j = 0; j < size; j++) {
                
            	 if (p!=j && tickets.get(j) == 0) {
                     continue;
                 }
                 tickets.set(j, tickets.get(j) - 1);
                 count++;
                 if ( (p == j) && tickets.get(j) == 0) {
                     done = true;
                     break;
                 } 
             }
         }
    	return count;


    }

}