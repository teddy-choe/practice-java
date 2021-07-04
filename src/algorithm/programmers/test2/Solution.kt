package algorithm.programmers.test2

import kotlin.math.min

fun main() {
    val solution = Solution()
    val bricks = intArrayOf(0, 0, 0, 0, 0)
    solution.solution(bricks, 5, 3)
}

class Solution {
    fun solution(bricks: IntArray, n: Int, k: Int): Int {
        val visited = Array(bricks.size) {false}
        var answer: Int = Int.MAX_VALUE

        fun dfs(depth: Int, count: Int, visited: Array<Boolean>) {
            if (depth == k-1) {
                answer = min(answer, count)
                return
            }

            bricks.forEachIndexed { index, brick ->
                // 양 끝과 이미 기존에 놓은 기둥 양옆에는 놓지 않습니다
                if (!visited[index] && index != 0 && index != bricks.size-1
                        && !visited[index-1] && !visited[index+1]) {
                    dfs(depth+1, count + n-brick, visited.clone().apply { set(index, true) })
                }
            }
        }

        val dfs = dfs(0, 0, visited)

        return answer
    }
}