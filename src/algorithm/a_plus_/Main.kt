package algorithm.a_plus_

import java.util.*

fun main(args: Array<String>) {
    val n = readLine()?.toInt()

    for (i in 0 until n!!) {
        val tokenizer = StringTokenizer(readLine(), " ")
        val a = tokenizer.nextToken().toInt()
        val b = tokenizer.nextToken().toInt()
        println("Case #" + (i+1) + ": " + a + " + " + b + " = " + (a+b))
    }
}