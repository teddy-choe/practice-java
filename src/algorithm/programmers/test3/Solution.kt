package algorithm.programmers.test3

import kotlin.math.min

fun main() {
    val solution = Solution()
    solution.solution(intArrayOf(0,-9,-9,-9,0,-9,-9,10,-2,-1,-1,-1,-1,-1,0,-2,-2,-1,-1,-1,0))
}

class Solution {
    fun solution(m: IntArray): Int {
        var answer: Int = Int.MAX_VALUE
        var visited = Array(m.size) {false}
        var dp = Array(1000) {-1}

        fun dfs(position: Int, count: Int, visited: Array<Boolean>) {
            if (position < 0) return

            if (position == m.size-1 || position > m.size-1) {
                answer = min(answer, count)
                return
            }

            if (!visited[position]) {
                val boardNum = m[position]

                if (boardNum == 0) {
                    for (i in 1..6) {
                        dfs(position + i, count+1, visited.clone().apply { set(position, true) })
                    }
                } else {
                    dfs(position + boardNum, count, visited.clone().apply { set(position, true) })
                }
            }
        }

        var dfs = dfs(0, 0, visited)

        return answer
    }
}