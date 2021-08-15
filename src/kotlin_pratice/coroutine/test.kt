package kotlin_pratice.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking{
    println("before!")

    coroutineScope {
        launch {
            delay(1100)
            println("1111")
        }

        withContext(Dispatchers.Default) {
            println("123")
            delay(1100)
        }

        withContext(Dispatchers.IO) {
            println("456")
        }
    }

    println("after!")
}