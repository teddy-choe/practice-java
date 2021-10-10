import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Counter counter = new Counter();

        Runnable task = () -> {
            for (int i=0; i< 10000; i++) {
                counter.increment();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Boolean> future1 = executorService.submit(task, true);
        Future<Boolean> future2 = executorService.submit(task, true);

        if (future1.get() && future2.get()) {
            System.out.println(counter.get());
        } else {
            System.err.println("실패");
        }

        executorService.shutdown();
    }
}

class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }

    int get() {
        return count.get();
    }
}
