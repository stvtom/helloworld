package database.mapper;

import database.model.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-07-18
 */
public interface CityMapper extends BaseMapper<City> {

    public List<City> findAllCity();

    public City getCityById(Integer id);

}


