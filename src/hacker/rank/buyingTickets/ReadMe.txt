Alex plans on visiting the museum and is at the counter to purchase tickets 
to get in. Tickets are sold only one at a time. If a visitor needs more than one 
ticket, he/she has to pass through the queue again to buy each one.

 

Given the number of visitors and the number of tickets each visitor needs, 
determine the amount of time Alex requires to buy the number needed. 
Alex's place in the queue will be given. Each transaction takes 1 unit of time. 
and the time taken to go to the back of the line can be ignored.

 

Example

n = 3

tickets = [1, 2, 5]

 

There are 3 buyers needing 1, 2 and 5 tickets each. Alex is at index 1 and need 2 tickets. The first six units of time, t = 0 through t = 5, are as shown below:

 

 


Alex's information is green both in the line to the ticket booth and in the boxes at the bottom. 

When a person has purchased all the tickets they need, they leave the line and their boxes are colored gray.

Alex finishes purchasing tickets[1] = 2 tickets at the 4th transaction.

 

Function Description 

Complete the function waitingTime in the editor below. The function must return an integer representing the units of time it takes Alex to purchase the desired number of tickets.

 

waitingTime has the following parameter(s):

    int tickets [n]:  a zero-indexed array of tickets desired by the person i at position tickets[i]

    int p: Alex's position in line

 

Constraints

1 ≤ n ≤ 105
1 ≤ tickets[i] ≤ 109, where 0 ≤ i < n.
0 ≤ p < n
 

Input Format for Custom Testing
Input from stdin will be processed as follows and passed to the function.

 

The first line contains an integer n, the size of the array tickets.

The next n lines each contain an element tickets[i] where 0 ≤ i < n.

The next line contains an integer p, Alex's position in line.

Sample Case 0
 

Sample Input 0

STDIN     Function
-----     --------
5    ⇒    tickets[] size n = 5
2    ⇒    tickets = [2, 6, 3, 4, 5]
6
3
4
5
2    ⇒    p = 2
 

Sample Output 0

12
 

Explanation 0

Given tickets = [2, 6, 3, 4, 5], Alex's position in line is marked in bold. The wait time looks like this:

window ← 2 ← 6 ← 3 ← 4 ← 5
window ← 6 ← 3 ← 4 ← 5 ← 1
window ← 3 ← 4 ← 5 ← 1 ← 5
window ← 4 ← 5 ← 1 ← 5 ← 2
window ← 5 ← 1 ← 5 ← 2 ← 3
window ← 1 ← 5 ← 2 ← 3 ← 4
window ← 5 ← 2 ← 3 ← 4 (the person at the head of the line in the previous step purchased their last ticket and does not re-enter the line)
window ← 2 ← 3 ← 4 ← 4
window ← 3 ← 4 ← 4 ← 1
window ← 4 ← 4 ← 1 ← 2
window ← 4 ← 1 ← 2 ← 3
window ← 1 ← 2 ← 3 ← 3
window ← 2 ← 3 ← 3 ( Alex purchased the last ticket needed and does not re-enter the line)
It took a total of 12 units of time (t = 0 through t = 11) to purchase 2 tickets.

Sample Case 1
Sample Input 1

STDIN     Function
-----     --------
4    ⇒    tickets[] size n = 4
1    ⇒    tickets = [1, 1, 1, 1]
1
1
1
0    ⇒    p = 0
 

Sample Output 1

1
 

Explanation 1

Given tickets = [1, 1, 1, 1], Alex's wait time looks like this:

window ← 1 ← 1 ← 1 ← 1
window ← 1 ← 1 ← 1 (Alex purchased the necessary ticket and did not re-enter the line)
It took a total of 1 unit of time to purchase 1 ticket.

Sample Case 2
Sample Input 2

STDIN     Function
-----     --------
4    ⇒    tickets[] size n = 4
5    ⇒    tickets = [5, 5, 2, 3]
5
2
3
3    ⇒    p = 3
 

Sample Output 2

11
 

Explanation 2

Given tickets = [5, 5, 2, 3], Alex's wait time looks like this:

window ← 5 ← 5 ← 2 ← 3
window ← 5 ← 2 ← 3 ← 4
window ← 2 ← 3 ← 4 ← 4
window ← 3 ← 4 ← 4 ← 1
window ← 4 ← 4 ← 1 ← 2
window ← 4 ← 1 ← 2 ← 3
window ← 1 ← 2 ← 3 ← 3
window ← 2 ← 3 ← 3 (the person at the head of the line in the previous step purchased their last ticket and did not re-enter the line)
window ← 3 ← 3 ← 1
window ← 3 ← 1 ← 2
window ← 1 ← 2 ← 2
window ← 2 ← 2 (Alex purchased the last ticket needed and did not re-enter the line)
It took a total of 11 units of time to purchase 3 tickets.

 