package database.controller.test;

import database.config.sync.ThreadPoolConfig;
import database.service.impl.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

    private static final Logger logger  = LoggerFactory.getLogger(JdbcController.class);

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "getUser")
    public Object getUser(@RequestParam(value = "id")String id){
        logger.info("getUser启动开始---id:{}",id);
        try {
            String s = jdbcTemplate.queryForObject("select name from city where id = ?", new String[]{id}, String.class);
            int i = 1 / 0;
            return s;
        }catch (Exception e) {
            logger.error("测试error日志");
        };

        new Thread(()->{
            logger.info("这是一个多线程测试 traceId为空");
        }).start();

        threadPoolTaskExecutor.execute(()->{
            logger.info("threadPoolTaskExecutor测试traceId");
        });

        //@Async 测试
        demoService.getName();
        return "error";
    }


}
