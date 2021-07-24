package database.config.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class ThreadPoolConfiguartion {

    @Bean(value = ThreadPoolConfig.taskThreadPoll)
    public ThreadPoolTaskExecutor initCommonThreadPool() {
        ThreadPoolTaskExecutor threadPool = new HydraThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(2);//核心线程数
        threadPool.setMaxPoolSize(4);//最大线程数
        threadPool.setKeepAliveSeconds(60);//线程存活时间
        threadPool.setQueueCapacity(10000);
        threadPool.setAllowCoreThreadTimeOut(false);
        threadPool.setThreadNamePrefix("common-thread-");//线程池前缀
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略， 调用者执行
        return threadPool;
    }

}
