/*You're given an integer N. Write a program to calculate the sum of all the digits of N.

Input
The first line contains an integer T, the total number of testcases. Then follow T lines, each line contains an integer N.

Output
For each test case, calculate the sum of digits of N, and display it in a new line.

Constraints
1 ≤ T ≤ 1000
1 ≤ N ≤ 1000000
Example
Input
3 
12345
31203
2123
Output
15
9
8*/
//package com.HakerRank;
 
import java.util.Scanner;

 class main {
    public static void main(String[] args) {
      Scanner s= new Scanner(System.in);
      try {
          int a = s.nextInt();
          for (int i = 1; i <= a; i++) {
              int x = sc.nextInt();
              int sum = 0;
              while (x != 0) {
                  int remainder = x % 10;
                  sum = sum + remainder;
                  x = x / 10;
              }
              System.out.println(sum);
          }
      }
      catch (Exception e){
          System.out.println(e);
      }

    }
}
