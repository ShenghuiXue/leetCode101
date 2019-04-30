/*
283. Move Zeroes
Easy

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/


/*
Inital idea : very similar to leetCode 80
use two pointers, one in for/while loop other one used for the poisition to move
none zeros to the right location, after finish, change the elements after second pointer to be 0
*/
class Solution {
    public void moveZeroes(int[] nums) {
        // two pointers to track the position for the elements
        int p1 = 0; // used to go through the array
        int p2 = 0; // used to update values in the array
        if (nums == null || nums.length == 0) return ;
        int len = nums.length;
        // I would like to try while loop this time
        while (p1<len) {
            if (nums[p1] !=0) {
                nums[p2] = nums [p1];
                p2++;
            }
            p1++;
        }
        // change the remaining elements after p2 to be 0
        while (p2<len) {
            nums[p2] = 0;
            p2++;
        }
    }
}

/*
What I learned?
Use two pointers, and that is all. 
*/
