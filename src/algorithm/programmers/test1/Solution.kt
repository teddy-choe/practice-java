package algorithm.programmers.test1

import kotlin.math.min

fun main() {
    val solution = Solution()

    val sizes = arrayOf(
            intArrayOf(60,50),
            intArrayOf(30,70),
            intArrayOf(60,30),
            intArrayOf(80,40))
    solution.solution(sizes)
}

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE

        // Set에 넣고 두개를 뽑아서 이 두 수 안에 모든 명함이 포개지는지 확인합니다
        var numberSet = HashSet<Int>()
        sizes.forEach {
            it.forEach { num ->
                numberSet.add(num)
            }
        }

        var selectedSize : Pair<Int, Int>
        for (i in 0 until numberSet.size-1) {
            for (j in i until numberSet.size) {
                selectedSize = Pair(numberSet.elementAt(i), numberSet.elementAt(j))
                var isValidContainSize = true

                sizes.forEach inner@ { size ->
                    if (!isValidCard(selectedSize, size)) {
                        isValidContainSize = false
                        return@inner
                    }
                }

                // 뽑은 두 수의 조합에 모든 카드가 포함될 경우
                if (isValidContainSize) {
                    answer = min(answer, selectedSize.first * selectedSize.second)
                }
            }
        }

        return answer
    }

    private fun isValidCard(selectedSize: Pair<Int, Int>, card : IntArray): Boolean {
        if (card[0] <= selectedSize.first && card[1] <= selectedSize.second) {
            return true
        }

        if (card[1] <= selectedSize.first && card[0] <= selectedSize.second) {
            return true
        }

        return false
    }
}