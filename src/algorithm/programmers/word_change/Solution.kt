package algorithm.programmers.word_change

import java.util.*

class Solution {
    fun isValidWord(cur: String, toChange: String) =
        cur.filterIndexed { index, c -> c != toChange[index] }.map { 1 }.sum()

    class Word(var depth: Int, var txt: String, var visited: Array<Boolean>)

    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val queue: Queue<Word> = LinkedList()
        var visited = Array(words.size) {false}
        queue.add(Word(0, begin, visited))

        while (!queue.isEmpty()) {
            val w = queue.poll()

            if (w.txt == target) {
                answer = w.depth
                break
            }

            w.visited.forEachIndexed { index, b ->
                if (!b && isValidWord(w.txt, words[index]) == 1) {
                    queue.add(
                            Word(
                                    w.depth + 1,
                                    words[index],
                                    w.visited.clone().apply { set(index, true) }
                            ))
                }
            }
        }

        return answer
    }
}