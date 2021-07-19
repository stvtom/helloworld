package database.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import database.model.City;
import database.mapper.CityMapper;
import database.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-07-18
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {



    @Override
    public Boolean updateCity(City city) {
        LambdaUpdateWrapper<City> updateWrapper = new LambdaUpdateWrapper();
//        Kabol
        updateWrapper.set(City::getDistrict,"Kabolaa").in(City::getId,1);
        boolean update = update(updateWrapper);
        return update;
    }

    @Override
    public City getCityByName(City city){
        LambdaQueryWrapper<City>lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(City::getName,"Kabul");
        City oneCity = getOne(lambdaQueryWrapper);
        return oneCity;
    }
}
