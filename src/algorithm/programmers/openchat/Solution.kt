package algorithm.programmers.openchat

import java.util.*

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val wordMap = mutableMapOf<String, String>()
        val printList = arrayListOf<String>()

        for (rec in record) {
            val tokenizer = StringTokenizer(rec, " ")
            val state = tokenizer.nextToken()

            if (state == "Enter" || state == "Change") {
                val uid = tokenizer.nextToken()
                val nickname = tokenizer.nextToken()

                wordMap[uid] = nickname
            }
        }

        for (rec in record) {
            val tokenizer = StringTokenizer(rec, " ")
            val state = tokenizer.nextToken()
            val uid = tokenizer.nextToken()

            if (state == "Enter") {
                printList.add("${wordMap[uid]}님이 들어왔습니다.")
            } else if (state == "Leave") {
                printList.add("${wordMap[uid]}님이 나갔습니다.")
            }
        }

        return printList.toTypedArray()
    }
}