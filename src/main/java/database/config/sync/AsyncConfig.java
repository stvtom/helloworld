package database.config.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.stereotype.Component;

/**
 * Spring Boot @Async
 * https://www.jianshu.com/p/c4c9aad86820
 */
@Slf4j
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public HydraThreadPoolTaskExecutor getAsyncExecutor() {
        HydraThreadPoolTaskExecutor threadPool = new HydraThreadPoolTaskExecutor();
        //设置核心线程数，默认为1
        threadPool.setCorePoolSize(1);
        // 当核心线程都在跑任务，还有多余的任务会存到此处。
        threadPool.setQueueCapacity(100);
        //最大线程数，默认为Integer.MAX_VALUE，如果queueCapacity存满了，还有任务就会启动更多的线程，直到线程数达到maxPoolSize。如果还有任务，则根据拒绝策略进行处理。
        threadPool.setMaxPoolSize(1);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(60 * 15);
        threadPool.setThreadNamePrefix("MyAsync-");
        threadPool.initialize();
        return threadPool;
    }
}
