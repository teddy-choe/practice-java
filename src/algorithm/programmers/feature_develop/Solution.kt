package algorithm.programmers.feature_develop

import java.util.*

fun main(args: Array<String>) {
    val progresses = intArrayOf(93, 30, 55)
    val speeds = intArrayOf(1, 30, 5)
    val solution = Solution()
    solution.solution(progresses, speeds)
}

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()

        val progressQueue : Queue<Int> = LinkedList()
        progressQueue.addAll(progresses.toTypedArray())

        val speedQueue : Queue<Int> = LinkedList()
        speedQueue.addAll(speeds.toTypedArray())

        var day = 0
        val list = mutableListOf<Int>()
        while (!progressQueue.isEmpty()) {
            day++
            var count = 0
            while (isFinishProgress(progressQueue.peek(), speedQueue.peek(), day)) {
                count++
                progressQueue.poll()
                speedQueue.poll()

                if (progressQueue.isEmpty()) break
            }

            if (count != 0) {
                list.add(count)
            }
        }

        answer = list.toIntArray()

        return answer
    }

    fun isFinishProgress(progress: Int, speed: Int, day: Int): Boolean = progress + speed * day >= 100
}