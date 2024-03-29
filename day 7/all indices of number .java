 /*
Problem Name: All indexes of x
Problem Level: MEDIUM
Problem Description: ####Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
####Do this recursively. Indexing in the array starts from 0.

#####Input Format :
    Line 1 : An Integer N i.e. size of array
    Line 2 : N integers which are elements of the array, separated by spaces
    Line 3 : Integer x

#####Output Format :
    indexes where x is present in the array (separated by space)

#####Constraints :
####1 <= N <= 10^3

 #####Sample Input : 
    5
    9 8 10 8 8
    8

#####Sample Output :
    1 3 4
    */

import java.util.Scanner;

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int x = s.nextInt();
		int output[] = Solution.allIndexes(input, x);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
}


public class Solution {

    
    
    public static int[] AllIndexesRecursive(int input[], 
                                int x, int start) 
    { 
        // If the start index reaches the 
        // length of the array, then 
        // return empty array 
        if (start == input.length) { 
            int[] ans = new int[0]; // empty array 
            return ans; 
        } 
  
        // Getting the recursive answer in 
        // smallIndex array 
        int[] smallIndex = AllIndexesRecursive(input, x, 
                                              start + 1); 
  
        // If the element at start index is equal 
        // to x then 
        // (which is the answer of recursion) and then 
        // (which came through recursion) 
        if (input[start] == x) { 
            int[] myAns = new int[smallIndex.length + 1]; 
  
            // Put the start index in front 
            // of the array 
            myAns[0] = start; 
            for (int i = 0; i < smallIndex.length; i++) { 
                  
                // Shift the elements of the array 
                // one step to the right 
                // and putting them in 
                // myAns array 
                myAns[i + 1] = smallIndex[i]; 
            } 
            return myAns; 
        } 
        else { 
              
            // If the element at start index is not 
            // equal to x then just simply return the 
            // answer which came from recursion. 
            return smallIndex; 
        } 
    } 
  
    public static int[] allIndexes(int input[], int x) 
    { 
  
        return AllIndexesRecursive(input, x, 0); 
    } 
      
	
	
}
