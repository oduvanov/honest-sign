package honestsign.component;

import java.util.concurrent.*;
import java.util.function.Function;

public class FunctionExecutor<K,V> {
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private ConcurrentMap<K, Future<V>> cache = new ConcurrentHashMap();

    Future<V> compute(K k, Function<K, V> f) {
        if (!cache.containsKey(k)) {
            FutureTask<V> task = new FutureTask(() -> f.apply(k));

            if (cache.putIfAbsent(k, task) == null) {
                executor.submit(task);
            }
        }

        return cache.get(k);
    }
}
