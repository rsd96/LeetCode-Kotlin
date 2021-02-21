/**

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
*/


class Solution {
    fun sortColors(nums: IntArray): Unit {
        var p = 0 // pointer to pass through the array 
        var p0 = 0 // pointer that ensures zeros are to the left 
        var p2 = nums.size - 1 // pointer to ensure twos are all on the right 
        
        while (p <= p2) {
            // if current value is 0 then swap with 0-pointer and increment both 
            if (nums[p] == 0) { 
                nums[p] = nums[p0]
                nums[p0] = 0
                p0++
                p++
            } else if (nums[p] == 2) {
                // if current value equals 2 then swap with 2-pointer but only decrement 2-pointer 
                // as swapped value may be not the right one for that index
                nums[p] = nums[p2]
                nums[p2] = 2
                p2--
            } else {
                p++; 
            }
        }
    }
}
