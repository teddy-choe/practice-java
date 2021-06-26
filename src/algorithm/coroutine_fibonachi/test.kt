package algorithm.coroutine_fibonachi

fun main(args: Array<String>) {
    val fibonacci = sequence {
        yield(1)
        var current = 1
        var next = 1
        while (true) {
            yield(next)
            val tmpNext = current + next
            current = next
            next = tmpNext
        }
    }

    val indexed = fibonacci.take(50).withIndex()

    for ((index, value) in indexed) {
        println("$index: $value")
    }
}

