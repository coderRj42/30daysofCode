/*Midori like chocolates and he loves to try different ones. There are N shops in a market labelled from 1 to N and each shop offers a different variety of chocolate. Midori starts from ith shop and goes ahead to each and every shop. But as there are too many shops Midori would like to know how many more shops he has to visit. You have been given L denoting number of bits required to represent N. You need to return the maximum number of shops he can visit.

Example 1:

Input: i = 2, L = 3
Output: 6
Explanation: There are 3 bits So N = 8
Hence midori can visit 8 - 2 = 6 more shops.
Example 2:

Input: i = 1, L = 2
Output: 3
Explanation: There are 2 bits so N = 4
Hence midori can visit 4 - 1 = 3 more shops.

Your Task:  
You dont need to read input or print anything. Complete the function leftShops() which takes i and L as input parameter and returns the maximum number of shops that midori can visit.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
1<= i <=N
1<= L <=30*/


class Solution {
    static long leftShops(long i, long L){
        // code here
return (1 << L) - i;
    }
}
