package algorithm.programmers.compress_string

import java.util.*

class Solution {
    data class Word (
            var count: Int,
            var word: String
    )

    fun solution(s: String): Int {
        var min = Integer.MAX_VALUE

        for (index in 1..s.length/2) {
            val compressed = LinkedList<Word>()

            var start: Int = 0
            var end: Int = 0

            while (end < s.length) {
                end = if (start + index > s.length) {
                    s.length
                } else {
                    start + index
                }
                val subStr = s.substring(start, end)

                if (compressed.isEmpty() || compressed.peekLast().word != subStr)
                    compressed.add(Word(1, subStr))
                else
                    compressed.peekLast().count++;

                start = end
            }

            val result : Int = compressed.fold(0) { acc, word ->
                val size : Int = if (word.count <= 1) {
                    word.word.length
                } else {
                    word.word.length + word.count.toString().length
                }

                acc + size
            }

            if (result < min) min = result
        }

        return min
    }
}