/*
Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)

(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: n = 5
Output: 12
Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
Example 2:

Input: n = 100
Output: 682289015
 

Constraints:

1 <= n <= 100
*/
class Solution {
    long d = 1_000_000_00;
    
    public long fact(long num){
        long fac=1;
        for(int i=1;i<=num;i++){
            fac = i*fac;
            fac = fac%d;
        }
        return fac%d;
    }
    
    public int numPrimeArrangements(int n) {
        long pcount=0;
        boolean prime;
        for(long i=2;i<=n;i++){
            prime = true;
            for(long j=2;j*j<=i;j++){
                if(i%j==0){
                    prime = false;
                    break;
                }
            }
            if(prime==true) pcount++;
        }
        long ans = fact(pcount)*fact(n-pcount);
        ans = ans%d;
        return (int)ans;
    }
}
