package algorithm.programmers.scoville

class Solution {
    fun solution(numbers: IntArray): String {
        var answer = ""

        numbers.sortedWith(Comparator { o1: Int, o2: Int ->
            "$o2$o1".compareTo("$o1$o2")
        }).forEach { answer += it }

        var pattern = "[1-9]".toRegex()
        if (pattern.containsMatchIn(answer) == false) {
            answer = "0"
        }

        return answer
    }
}