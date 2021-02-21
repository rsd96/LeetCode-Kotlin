/**

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 -----------
| 1 | 3 | 1 |
|-----------| 
| 1 | 5 | 1 |
|-----------|
| 4 | 2 | 2 |
 -----------

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
*/

// Solution 

class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        // map to save sum of sub grid to prevent save runtime 
        var memo = mutableMapOf<String, Int>()
        return travel(grid, 0, 0, memo)
    }
    
    fun travel(grid: Array<IntArray>, m: Int, n: Int, memo: MutableMap<String, Int>): Int {
        // Create a string key using indices, seperate by comma to avoid confusino when it 
        // comes to double digits for example 
        // m = 44, n = 9 & m = 4, n = 49 will both have same key of 449 without comma 
       
        val key = "" + m + "," + n
        
        // if key exists then return 
        if (memo.containsKey(key))
            return memo[key] ?: 0
            
        // we reached the last cell in grid so return the value itself 
        if (m == grid.size-1 && n == grid[0].size-1) 
            return grid[m][n]
        // if m or n is out of bounds, return a large value so Min function ignores this 
        if (m >= grid.size || n >= grid[0].size) 
            return Int.MAX_VALUE
            
        // sum of min path is equal to current value plus Min of left subtree or right subtree 
        memo[key] = grid[m][n] + Math.min(travel(grid, m+1, n, memo), travel(grid, m, n+1, memo))
        return memo[key] ?: 0
    }
}
