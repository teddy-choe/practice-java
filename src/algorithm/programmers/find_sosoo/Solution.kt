package algorithm.programmers.find_sosoo

fun main(args: Array<String>) {
    val solution = Solution()
    solution.solution("17")
}

class Solution {
    val list : MutableSet<Int> = mutableSetOf()

    fun solution(numbers: String): Int {
        var answer = 0

        val intNums : Array<Int> =
                numbers.toCharArray().map {
                    Integer.parseInt(it.toString())
                }.toTypedArray()

        for (i in 1 .. numbers.length) {
            makePermutaion(intNums, 0, numbers.length, i)
        }

        for (num in list) {
            if (isSosoo(num)) answer++
        }

        return answer
    }

    fun makePermutaion(numbers: Array<Int>, depth: Int, n: Int, r: Int) {
        if (depth == r) {
            // numbers -> int
            // add int to list
            val stringBuffer = StringBuffer()
            for (i in 0 until r) {
                stringBuffer.append(numbers[i])
            }

            list.add(Integer.parseInt(stringBuffer.toString()))

            return
        }

        for (i in depth until n) {
            swap(numbers, depth, i)
            makePermutaion(numbers, depth+1, n, r)
            swap(numbers, depth, i)
        }
    }

    private fun swap(arr: Array<Int>, depth: Int, i: Int) {
        val temp = arr[depth]
        arr[depth] = arr[i]
        arr[i] = temp
    }

    fun isSosoo(num: Int) : Boolean {
        if (num < 2) {
            return false
        }

        if (num == 2) {
            return true
        }

        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }

        return true
    }
}