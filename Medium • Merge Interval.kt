/**
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/



class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        
        /**
        Sort intervals to be in sequence 
        e.g: 
         1 - - 4
           2 - - 5
                   6 - - - 10
        */
        
        intervals.sortBy { it[0] }
        
        // get first interval as first candidate
        var start = intervals[0][0]
        var end = intervals[0][1]
     
        // array to store merged intervals 
        var res = arrayListOf<IntArray>()
        
        intervals.forEach {
            val currIntervalStart = it[0]
            val currIntervalEnd = it[1] 
            // Check if current interval falls out of candidate interval 
            if (currIntervalStart > end) {
                // add previous candidate to res and make current interval the new candidate 
                res.add(intArrayOf(start, end))
                start = currIntervalStart
                end = currIntervalEnd
            }else {
                // if interval marges with candidate interval then update end if 
               //  current end is greater than candidate
                if (currIntervalEnd > end)
                    end = currIntervalEnd
            }
        }
        // add final candidate to the res
        res.add(intArrayOf(start, end))
        
        
        return res.toTypedArray()
    }
}
