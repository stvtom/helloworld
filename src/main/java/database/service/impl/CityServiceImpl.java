package database.service.impl;

import database.model.City;
import database.mapper.CityMapper;
import database.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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


}
