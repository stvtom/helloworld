package database.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JdbcController {

    private static final Logger logger  = LoggerFactory.getLogger(JdbcController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "getUser")
    public Object getUser(@RequestParam(value = "id")String id){
        logger.info("getUser启动开始---id:{}",id);
        return jdbcTemplate.queryForObject("select name from city where id = ?", new String[]{id}, String.class);
    }

}
