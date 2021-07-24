package database.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoService {

    @Async
    public void getName(){
        log.info("测试@Async自写线程池 traceId");
    }
}
