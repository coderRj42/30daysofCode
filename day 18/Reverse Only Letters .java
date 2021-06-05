/*Given a string s, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Note:

s.length <= 100
33 <= s[i].ASCIIcode <= 122 
s doesn't contain \ or "*/
 class Solution {
    public String reverseOnlyLetters(String s) {
        int beginIndex = 0;
        int lastIndex = s.length() - 1;
        char[] arr = s.toCharArray();
        while (beginIndex < lastIndex) {

            if (Character.isLetter(arr[beginIndex]) && Character.isLetter(arr[lastIndex])) {
                char temp = arr[beginIndex];
                arr[beginIndex] = arr[lastIndex];
                arr[lastIndex] = temp;
                beginIndex++;
                lastIndex--;
            }

            if (!Character.isLetter(arr[beginIndex]))
                beginIndex++;

            if (!Character.isLetter(arr[lastIndex]))
                lastIndex--;
        }

        return new String(arr);
    }
}
