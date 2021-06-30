package algorithm.lotto_max_min

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val max = lottos.filter { win_nums.contains(it) || it == 0 }.size
        val min = lottos.filter { win_nums.contains(it) }.size

        return intArrayOf(rank(max), rank(min))
    }

    fun rank(num : Int) = if (num < 2) 6 else 7-num
}