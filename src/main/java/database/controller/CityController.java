package database.controller;


import com.alibaba.fastjson.JSON;
import database.mapper.CityMapper;
import database.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-07-18
 */
@RestController
@RequestMapping("/city")
public class CityController {


    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("findAllUser")
    public String findAllUser(){
        List<City> allUser = cityMapper.findAllUser();
        return JSON.toJSONString(allUser);
    }
}
