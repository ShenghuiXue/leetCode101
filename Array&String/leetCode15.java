/*
15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

/*
Initial thoughts:
Same as two sum, however, this time may contains duplicated numbers, then, we cannot
use hashset.
Brutal force solution will be three for-loops, but this is slow
how about sort array first, then add two numbers, determine it is a positive number or
negative number, sort can definitely the solution faster

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List <Integer>> result = new ArrayList <> ();

    }
}
