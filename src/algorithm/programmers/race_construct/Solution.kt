package algorithm.programmers.race_construct

import java.util.*
import kotlin.math.abs
import kotlin.math.max

fun main() {
    val solution = Solution()
    val board = arrayOf(intArrayOf(0,0,0), intArrayOf(0,0,0), intArrayOf(0,0,0))
    solution.solution(board)
}

class Solution {
    data class Node(
            var row: Int,
            var col: Int,
            var cost: Int,
            var dir: Int
    )

    fun solution(board: Array<IntArray>): Int {
        var dx = arrayOf(-1, 0, 1, 0)
        var dy = arrayOf(0, 1, 0, -1)
        var costMap : Array<IntArray> = Array(board.size) { IntArray(board.size) {Integer.MAX_VALUE} }

        fun bfs() {
            val queue : Queue<Node> = LinkedList()
            queue.add(Node(0,0,0,-1))

            while (!queue.isEmpty()) {
                val cur = queue.poll()

                for (i in 0..3) {
                    val ny = cur.row + dy[i]
                    val nx = cur.col + dx[i]

                    if (ny < 0 || ny >= board.size || nx < 0 || nx >= board.size) continue

                    if (board[ny][nx] == 1) continue

                    var nextCost = if (cur.dir == -1) {
                        cur.cost + 100
                    } else if (abs(cur.dir - i) == 2) {
                        cur.cost + 100
                    } else {
                        cur.cost + 600
                    }

                    if (costMap[ny][nx] > nextCost) {
                        costMap[ny][nx] = nextCost
                        queue.add(Node(ny, nx, nextCost, i))
                    }
                }
            }
        }

        val num = bfs()

        return costMap[board.size-1][board.size-1]
    }
}