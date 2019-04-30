/*
80. Remove Duplicates from Sorted Array II
Medium

Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

*/

/*
my naive solution: two pinters to keep track poistions in array
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        // if the array is empty or null, then return 0
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        // now handle the most common cases
        int counter = 1; // counter number of repeats
        int p = 0; // this int moves only there is no repeat, inital position is 0
        int temp = nums [0]; //initial the temp varaible to be equal to nums [0]
        // use for loop to loop through the array for comparision with temp,
        // starting from the second position and compare with the temp
        for (int i = 1; i<nums.length; i++) {
            if (counter == 1) {
                if (temp != nums [i]) {
                    // update the temp with the new number in the array
                    temp = nums [i];
                    //move p to the next poistion
                    p++;
                    // count still holds value of 1
                } else { // if temp and the nums [i] are the same
                    counter++; //keep track the repeats
                    p++; // still move the pointer
                }
            } else  { // counter >1
                if (temp != nums [i]) { // if the temp and the number in the current array are different
                    counter = 1; // now the counter is set to 1 as an indication that differnt num shows up
                    // update the temp as the current value in the array
                    temp = nums [i];
                    //move p to the next poistion
                    p++;


                } else { // if these the number in the array is equal to the temp and now it has more than 2 repeat
                    // we need to "delete" the number by not move the pointer p
                    counter++; // update counter to record number of repeats
                    // the position of p will stay unchanged
                    // temp will not be updated
                }
            }
            // update the nums [p] as nums[i];
            nums [p] = temp;
        }
        // set nums [p+1] = null;
        // nums [p+1] = null;
        return p+1;
    }
}

/*
What I learn
1. use two pointers: i to loop through the array and p is an alternave pointer to track another location to modify array
2. we can reuse the same array to replace the places which have been deleted with temp
3. two variables keep tracking whether the number are repated twice
4. pointer p can be used as a inditator for the length of the modified array
*/
