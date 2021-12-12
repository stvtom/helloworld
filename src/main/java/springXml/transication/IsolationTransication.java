package springXml.transication;


import database.model.City;
import database.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1、读未提交(排他锁会阻止其它事务再对其锁定的数据加读或写的锁，但是对不加锁的读就不起作用了。)、
 * 2、不可重复读(在读已提交的级别下，都会通过MVCC获取当前数据的最新快照)、
 * 3、读已提交（级别不同的是MVCC版本的生成时机，即：一次事务中只在第一次select时生成版本，
 * 后续的查询都是在这个版本上进行，从而实现了可重复读）、
 * 4、串行化
 */
@Service
public class IsolationTransication {

    @Autowired
    private CityServiceImpl cityService;

//     读未提交：可能出现脏读
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
//     读已提交（不可重复读）：两次读出来的数据可能不一致
    @Transactional(isolation = Isolation.READ_COMMITTED)
//     可重复读
//    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public City getCity(){
        City byId = cityService.getById(1);
        System.err.println(byId);
        try {
            System.err.println("===================暂停9秒钟===========");
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //在READ_COMMITTED（不可重复读模式下）。
        // 预期：在事物B中更改数据id为1的内容后，在事物B更改前后查询出来的结果不一致
        // 结果：在事物B更改前后，用相同的SQL查询两次查询的结果一致
        // 原因：mybatis存在缓冲，相同sql查询的缓存的数据
//        City byId1 = cityService.getById(1);
        City byId1 = cityService.getCityByName(null);
        System.err.println(byId1);
        return byId;
    }
}
