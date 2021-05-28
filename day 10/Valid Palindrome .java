/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/
 class Solution {
    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int j=1;
        
        for (int i = 0; i<s.length(); i++){

            if (s.charAt(i) != s.charAt(s.length()-j++)){

                return false;
            }

        }
        return true;
    }

}
