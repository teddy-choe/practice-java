import io.reactivex.rxjava3.core.Flowable
import java.util.concurrent.TimeUnit

enum class State {
    ADD, MULTIPLY
}

var calcMethod : State = State.ADD

fun main() {
    val flowable : Flowable<Long> = Flowable.interval(400L, TimeUnit.MILLISECONDS)
            .take(9)
            .scan { sum: Long, data: Long ->
                if (calcMethod == State.ADD) {
                    return@scan sum + data
                } else {
                    return@scan sum * data
                }
            }

    flowable.subscribe { data ->
        println("data =  $data")
    }

    Thread.sleep(1000)
    println("계산 방법 변경")
    calcMethod = State.MULTIPLY

    Thread.sleep(3000)
}