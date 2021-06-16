/*Given an integer, check whether it is Bleak or not.

A number ‘n’ is called Bleak if it cannot be represented as sum of a positive number x and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative number x.

Example 1:

Input: 4
Output: 1
Explanation: There is no any possible x
such that x + countSetbit(x) = 4
Example 2:

Input: 3
Output: 0
Explanation: 3 is not a Bleak number as 
2 + countSetBit(2) = 3.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function is_bleak() which takes n as input parameter and returns 1 if n is not a Bleak number otherwise returns 0.
 

Expected Time Complexity: O(log(n) * log(n))
Expected Space Complexity: O(1)
 

Constraints:
1 <= n <= 104


*/


 import java.io.*;

class test {

 	static int countSetBits(int x)
	{
		int count = 0;
		while (x != 0) {
			x &= (x - 1);
			count++;
		}
		return count;
	}

 	static boolean isBleak(int n)
	{
 		for (int x = 1; x < n; x++)
			if (x + countSetBits(x) == n)
				return false;

		return true;
	}

 	public static void main(String args[])
	{
		if (isBleak(3))
			System.out.println("Yes");
		else
			System.out.println("No");
		if (isBleak(4))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
 
