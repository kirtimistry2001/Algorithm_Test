package hacker.rank.LastAndSecondLast;

public class Solution {
	public static void main(String[] args) {//throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

   //     String word = bufferedReader.readLine();

        String result = Result.lastLetters("APPLE");

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}




class Result {

    /*
     * Complete the 'lastLetters' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING word as parameter.
     */

    public static String lastLetters(String word) {
    // Write your code here
       // System.out.println(word);
        String result = word.substring(word.length()-1, word.length());
        result = result +" "+ word.substring(word.length()-2, word.length()-1);
        //System.out.println(result);
        return result;
    }

}

