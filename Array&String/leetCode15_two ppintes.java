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
      if (nums == null || nums.length<3) return result;
      // sort array first
      Arrays.sort (nums);
      // next loop-through the sorted array if the value is larger than 0, stop
      for (int i =0; i<nums.length-2; i++) {
          if (nums[i] >0) break; // if current number is larger than 0, it is impossible to adde three positive numbers to be 0
          // additional two pointers to swipe through the array after i in two directions.
          if (i == 0 || (i>0 && nums[i] != nums[i-1])) {
              int target = 0-nums[i];// use a int to store the numers to avoid repeat calculations
              int p1 = i+1;
              int p2 = nums.length-1;
              while (p1<p2) {
                  if ( (nums[p1]+nums[p2]) == target ) {
                      // add three numbers into the result
                      result.add (Arrays.asList(nums[i], nums [p1], nums [p2]));
                      // move p1 and p2 to new location
                      while (p1<p2 && nums[p1+1]==nums[p1]) p1++;
                      while (p1<p2 && nums[p2]==nums[p2-1]) p2--;
                      p1++;
                      p2--;
                  } else if ((nums[p1]+nums[p2]) > target) {
                      p2--;
                  } else {
                      p1++;
                  }
              }
          }
      }
      return result;
    }
}

/*
What did I learn?
1. the constrctor for array: Arrays.asList (int 1, int 2, int 3) return a List<Integer>
2. sort array Arrays.sort(nums);
3. Using two pointer to handle 2 sum with while loop. Don't forget p1++ p2-- to
avoid infinite loop
4. I think it is also possible to use HashSet since non-dulicates list are used.
*/
