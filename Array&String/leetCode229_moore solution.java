/*
229. Majority Element II
Medium
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

*/

/*
Main idea to solve this type of problem using Moore's voting:
For aan array with size of n, it is impossible to have three elements which
have frequency larger than n/3
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<> ();
        // first consider the extreme condition
        if (nums == null || nums.length == 0) return result;
        int num1 = nums[0];
        int num2 = nums[0];
        int counter1 = 0;
        int counter2 = 0;
        int len = nums.length ;
        // use a for loop to go though the input array
        for (int i = 0; i <len; i++) {
            // check if the the value of the current element in the array is equal
            // to the num1 or num2
            if (num1 == nums[i]) {
                counter1++;// update the counts of that number
            } else if (num2 == nums [i] ) {
                counter2++; // update the counts of that number
            } else if (counter1 == 0) {
                num1 = nums [i]; // if one of the counter (counter 1) is 0, we need the update num1
                counter1 = 1;
            } else if (counter2 == 0) {
                num2 = nums [i];
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }
        // now we have two numbers, but we cannot garantee that both number have
        // frequence larger than n/3, and we have to go though the array one more time
        counter1 = 0;
        counter2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num1) {
                counter1++;
            } else if (nums[i] == num2) {
                counter2++;
            }
        }
        // add the number to the results if the corresponding counter is larger than n/3
        if (counter1 > len/3) result.add (num1);
        if (counter2 > len/3) result.add (num2);
        return result;

    }
}
