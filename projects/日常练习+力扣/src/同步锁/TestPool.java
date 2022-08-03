package 同步锁;

import java.util.concurrent.*;

/**
 * @program: 0606
 * @description: 练习线程池
 * @author: Wangbobo
 * @created: 2022/06/10 16:37
 */
public class TestPool {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 0L,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
    }
}
