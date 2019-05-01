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
      Set<List <Integer>> result = new HashSet <> ();
      if (nums == null || nums.length<3) return result;
      // sort array first
      Arrays.sort (nums);
      // next loop-through the sorted array if the value is larger than 0, stop
      for (int i =0; i<nums.length-2; i++) {
          //if (nums[i] >0) break; // if current number is larger than 0, it is impossible to adde three positive numbers to be 0
          // additional two pointers to swipe through the array after i in two directions.
          int sum = 0 - nums[i];
          if (i == 0 || (i>0 && nums[i] != nums[i-1])) { // remove the repeated result
              Set <Integer> set = new HashSet<> ();
              for (int j = i+1; j<nums.length; j++) {
                  if (set.contains (sum-nums[j])) {
                      result.add (Arrays.asList (nums[i], sum-nums[j], nums[j]));
                      //break;
                  }
                  set.add (nums[j]);
              }
          }
      }
      return new ArrayList (result);
    }
}

/*
What did I learn?
1. Set Set <obj> set = new HashSet<>();
2. set.add()  set.contains
3. two pointer is faster than hashSet because it is capable of eliminating a lot of repeated numbers
*/
