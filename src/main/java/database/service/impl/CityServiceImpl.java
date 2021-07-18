package database.service.impl;

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
        updateWrapper.set(City::getDistrict,"Kabol").in(City::getId,1);
        boolean update = update(updateWrapper);
        return update;
    }
}
