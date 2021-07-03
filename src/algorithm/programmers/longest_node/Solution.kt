package algorithm.programmers.longest_node

import java.util.*

fun main(args: Array<String>) {
    val solution = Solution()
    val edges : Array<IntArray> = arrayOf(
            intArrayOf(3,6),
            intArrayOf(4,3),
            intArrayOf(3,2),
            intArrayOf(1,3),
            intArrayOf(1,2),
            intArrayOf(2,4),
            intArrayOf(5,2)
            )
    solution.solution(6, edges)
}

class Solution {
    fun solution(n: Int, edges: Array<IntArray>): Int {
        var answer = 0

        val adjList = MutableList(n+1) { mutableListOf<Int>()}
        for (edge in edges) {
            adjList[edge[0]].add(edge[1])
            adjList[edge[1]].add(edge[0])
        }

        answer = bfs(adjList)

        return answer
    }

    fun bfs(list : List<List<Int>>): Int {
        val queue : Queue<Pair<Int, Int>> = LinkedList()
        var visited = BooleanArray(list.size+1) {false}
        queue.add(Pair(1, 0))
        visited[1] = true
        var longDis = 0
        var count = 0

        while (!queue.isEmpty()) {
            val pair = queue.poll()

            if (longDis < pair.second) {
                longDis = pair.second
                count = 0
            }

            if (longDis == pair.second) {
                count++
            }

            val iterator = list[pair.first].iterator()
            while (iterator.hasNext()) {
                val num = iterator.next()

                if (!visited[num]) {
                    visited[num] = true
                    queue.add(Pair(num, pair.second + 1))
                }
            }
        }

        return count
    }
}