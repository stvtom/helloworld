package database.controller;


import com.alibaba.fastjson.JSON;
import database.mapper.CityMapper;
import database.model.City;
import database.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-07-18
 */
@Slf4j
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("findAllCity")
    public String findAllCity(){
        List<City> allUser = cityMapper.findAllCity();
        log.info("allCity:{}",JSON.toJSONString(allUser));
        return JSON.toJSONString(allUser);
    }

    @RequestMapping("findCityById")
    public String findCityById(Integer id){
        City cityById = cityMapper.getCityById(id);
        log.info("cityById:{}",JSON.toJSONString(cityById));
        return JSON.toJSONString(cityById);
    }

}
