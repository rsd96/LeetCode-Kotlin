/**

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6


*/


class Solution {
    
    fun uniquePaths(m: Int, n: Int): Int {
        return travel(m, n, mutableMapOf())
    }
    
    fun travel(m: Int, n: Int, memo: MutableMap<String, Int>): Int {
        var key = m.toString() + "," + n 
        if (memo.containsKey(key))
            return memo[key] ?: 1
        
        if (m == 1 && n == 1) 
            return 1
        
        if (m == 0 || n == 0) 
            return 0
        
        memo[key] = travel(m-1, n, memo) + travel(m, n-1, memo)
        return memo[key] ?: 0
    }
}

