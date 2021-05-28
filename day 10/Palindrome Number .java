/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

 

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
*/
class Solution {
    public boolean isPalindrome(int x) {
        int t = x;
        int y = 0;
        if (x < 0) return false;
        while (x != 0) {
            y *= 10;
            y += (x % 10);
            x /= 10;
        }
        return t == y;
    }
}
