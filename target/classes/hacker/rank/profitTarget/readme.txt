Profit Targets
View
Try
Insights
Recommended Time: 24 mins
Points: 75
15 test cases (5 samples)
Skills:Problem Solving (Intermediate)
CodingBinary SearchData StructuresMEDIUMAlgorithmsArraysProblem SolvingTheme: FinanceInterviewer Guidelines
A financial analyst is responsible for a portfolio of profitable stocks represented in an array. Each item in the array represents the yearly profit of a corresponding stock. The analyst gathers all distinct pairs of stocks that reached the target profit. Distinct pairs are pairs that differ in at least one element. Given the array of profits, find the number of distinct pairs of stocks where the sum of each pair's profits is exactly equal to the target profit.
 

Example

stocksProfit = [5, 7, 9, 13, 11, 6, 6, 3, 3]

target = 12 profit's target

 

There are 4 pairs of stocks that have the sum of their profits equals to the target 12 . Note that because there are two instances of 3 in stocksProfit there are two pairs matching (9, 3): stocksProfits indices 2 and 7, and indices 2 and 8, but only one can be included.
There are 3 distinct pairs of stocks: (5, 7), (3, 9), and (6, 6) and the return value is 3.
 

Function Description 

Complete the function stockPairs in the editor below.

 

stockPairs has the following parameter(s):

    int stocksProfit[n]: an array of integers representing the stocks profits

    target: an integer representing the yearly target profit

Returns:

    int: the total number of pairs determined

 

Constraints

1 ≤ n ≤ 5 × 105
0 ≤ stocksProfit[i] ≤ 109
0 ≤  target ≤ 5 × 109
 

Input Format for Custom Testing
Input from stdin will be processed as follows and passed to the function.

 

The first line contains an integer n, the size of the array stocksProfit.

The next n lines each contain an element stocksProfit[i] where 0 ≤ i < n.

The next line contains an integer  target, the target value.

Sample Case 0
Sample Input 0

STDIN      Function
-----      --------
6      →   stocksProfit[] size n = 6
1      →   stocksProfit = [1, 3, 46, 1, 3, 9]
3      
46    
1      
3      
9      
47     →   target = 47
Sample Output 0

1
Explanation 0

 

There are 4 pairs where stocksProfit[i] + stocksProfit[j] = 47

(stocksProfit0] = 1, stocksProfit[2] = 46)
(stocksProfit[2] = 46, stocksProfit[0] = 1)
(stocksProfit[2] = 46, stocksProfit[3] = 1)
(stocksProfit[3] = 1, stocksProfit[2] = 46)
Since all four pairs contain the same values, there is only 1 distinct pair of stocks : (1, 46).

Sample Case 1
Sample Input 1

STDIN      Function
-----      --------
7      →   stocksProfit[] size n = 7
6      →   stocksProfit = [6, 6, 3, 9, 3, 5, 1]
6      
3      
9      
3      
5      
1      
12     →   target = 12
Sample Output 1

2
Explanation 1

 

There are 5 pairs where stocksProfit[i] + stocksProfit[j] = 12:

(stocksProfit[0] = 6, stocksProfit[1] = 6)
(stocksProfit[1] = 6, stocksProfit[0] = 6)
(stocksProfit[2] = 3, stocksProfit[3] = 9)
(stocksProfit[3] = 9, stocksProfit[2] = 3)
(stocksProfit[3] = 9, stocksProfit[4] = 3)
(stocksProfit[4] = 3, stocksProfit[3] = 9)
The first 2 pairs are the same, as are the last 4. There are only 2 distinct pairs of stocks: (3, 9) and (6, 6).

