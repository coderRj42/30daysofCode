 /*
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//create array of size(length of 1st array plus length of second array)
		int[] fin = new int[nums1.length + nums2.length] ;
		
		int i =0;
		int j = 0;
		int k = 0;
	 
		
		while(i < nums1.length && j < nums2.length) {
			if(nums1[i] < nums2[j]) {
				fin[k] = nums1[i];
				i++;
				k++;
			}
			else {
				fin[k] = nums2[j];
				j++;
				k++;
			}
		}
		
		if(i < nums1.length) {
			while(i < nums1.length) {
				fin[k] = nums1[i];
				k++;
				i++;
			}
		}
		else {
			while(j < nums2.length) {
				fin[k] = nums2[j];
				k++;
				j++;
			}
		}
		
	
		if(fin.length % 2 ==  0) {
			return (fin[fin.length/2] + fin[(fin.length/2)- 1] ) / (2 * (1.0));
		}
		else {
			return fin[fin.length/2];
		}
	    
		
        
        
        
        
    }
       
}
