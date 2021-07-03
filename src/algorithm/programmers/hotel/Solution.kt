package algorithm.programmers.hotel

fun main(args: Array<String>) {
    val solution = Solution()
    solution.solution(10, longArrayOf(1,3,4,1,3,1))
}

class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        var answer = longArrayOf()

        val table = HashMap<Long, Long>()
        val list = mutableListOf<Long>()

        fun setRoom(value: Long): Long {
            var index = value
            while (table.containsKey(index)) {
                index++
            }
            table.put(index, 0)
            return index
        }

        for (num in room_number) {
            val real = setRoom(num)
            list.add(real)
        }

        answer = list.toLongArray()

        return answer
    }
}