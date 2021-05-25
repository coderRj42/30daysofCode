/*
Problem Name: Sum of array (recursive)
Problem Level: EASY
Problem Description: #### Given an array of length N, you need to find and return the sum of all elements of the array.
####Do this recursively. 

##### Input Format :
    Line 1 : An Integer N i.e. size of array
    Line 2 : N integers which are elements of the array, separated by spaces

##### Output Format :
    Sum

##### Constraints :
    1 <= N <= 10^3

 #####Sample Input 1 : 
    3
    9 8 9

#####Sample Output 1 :
    26

#####Sample Input 2 : 
    3
    4 2 1

#####Sample Output 2 :
    7    
    */
import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(Solution.sum(input));
	}
}

 public class Solution {

	public static int sum(int input[]) {
		return sum(input, 0); 
	}
    
    static int sum(int a[], int SI){
        if(SI== a.length)
            return 0;
        int s = sum(a, SI+1);
        s+=a[SI];
        return s;
    }
    
}
