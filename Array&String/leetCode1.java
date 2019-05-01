/*
1. Two Sum
Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

/*
I would like to save these data in hashset, if target is 9, then we are finding the num 2 in the ararry == 9- num1
this array is not sorted
this array can have repeated elements
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
      int [] resultIndex = new int [2];
      if (nums == null || nums.length <2) return null;
      // use a map to stope each elments and its index
      Map <Integer, Integer> map = new HashMap <Integer, Integer> ();
      for (int i = 0; i < nums.length; i++) {

        if ( map.containsKey (target-nums[i])) {
          resultIndex[0] = map.get (target-nums[i]);
          resultIndex[0] = i;
          return resultIndex;
        }
        map.put (nums[i], i);
      }
      return resultIndex;

    }
}

/*
What did I learn?
1. revisit HashMap API map.get(key key), map.containsKey(key key) map.put (key key, value, value)
2. I get confused with map.values
3. array constructor: int [] arr = new int [666];

*/
