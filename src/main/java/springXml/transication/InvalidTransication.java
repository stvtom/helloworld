package springXml.transication;

import database.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Spring事务不生效的原因大解读
// https://blog.csdn.net/f641385712/article/details/80445933
@Service
public class InvalidTransication {

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private ValidTransication validTransication;

    @Transactional
    public int creat(){
        Boolean aBoolean = cityService.updateCity(null);
        int i = 1/0;
        return 0;
    }

    /**
     * 1.@Transactional的事务开启 ，或者是基于接口的 或者是基于类的代理被创建。
     * 所以在同一个类中一个无事务的方法调用另一个有事务的方法，事务是不会起作用的
     *
     * 2.Spring使用声明式事务处理，抛出一个runtimeException才能回滚
     *
     * 3.必须是Spring容器代理的类、数据库必须支持事物、调用的方法必须是public
     */
    public void addInfo(){
        creat();
    }

}
