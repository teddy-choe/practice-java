package kotlin_pratice.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking{
    println("before!")

    GlobalScope.launch {
        launch { // launch coroutine in the main thread
            for (i in 10 downTo 1) { // countdown from 10 to 1
                println("count : $i")
                delay(500) // wait half a second
            }
            println("done!")
        }

        launch { // launch coroutine in the main thread
            for (i in 1 .. 10) { // countdown from 10 to 1
                println("count : $i")
                delay(500) // wait half a second
            }
            println("done!")
        }
    }.join()

    println("after!")
}