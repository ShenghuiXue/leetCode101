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

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // if the length of the array is less than 3, then it
        List <Integer> result = new ArrayList <Integer> ();
        HashMap <Integer, Integer> map = new HashMap <Integer, Integer> ();
        if (nums == null || nums.length ==0) return result;
        int limit = nums.length/3;
        // use hashmap to keep track of the frequency of each numberis,
        // if the frequence is larger than limit, then add to the result
        // and then change frequene to -1 to indicate that this number has
        // be added to the results
        int tmp;
        for (int i = 0; i<nums.length; i++) {
            tmp = nums [i];
            if (!map.containsKey (tmp)) {
                map.put (tmp, 1);
            }
            //check values for this key
            int value = map.get (tmp); //get value/frequency of this key
            // now check if value > limit to do something
            if (value > limit) {
                // add tmp to the results
                result.add (tmp);
                // change value = -1 (means this key has been added to result)
                map.replace (tmp, -1);
            } else if (value >= 0 && value <=limit) {
                map.replace (tmp,  value+1); // update the frequence the tmp in the may
            }
        }
        return result;
    }
}

/*
What did I learn:
1. Hashmap APIs
    create a HashMap : HashMap <obj,obg> map = new HashMap <obj,obj>();
    check keys: map.containsKey(key key)
    add key value paris: map.put (key key, value value)
    update value in Hashmap map.repeat (key key, value value)
2. ArrayList API:
    creat an ArrayList: ArrayList <obj> li = new ArrayList <>();
    add value to the list li.add (value value);
3. I need findout a better solution, current solution is too slow, even with hashmap, there must be a better 
   way to solve such problem. 
*/
