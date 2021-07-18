package database.service;

import database.model.City;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-07-18
 */
public interface ICityService extends IService<City> {

    Boolean updateCity(City city);
}
