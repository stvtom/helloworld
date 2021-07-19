package springXml.transication;


import database.mapper.CityMapper;
import database.service.impl.CityServiceImpl;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *  Spring编程式事务的使用
 *  https://blog.csdn.net/lsziri/article/details/80656600
 */
@Service
public class ProgrammingTransication {

    private static final Logger logger  = LoggerFactory.getLogger(ProgrammingTransication.class);

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private CityServiceImpl cityService;

    public void programTransication1(){

        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                try {
                    Boolean aBoolean = cityService.updateCity(null);
                    int i = 1 / 0;
                    return aBoolean;
                }catch (Exception e){
                    // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
                    logger.error("事物异常:{}",e.getMessage());
                    return false;
                }
            }
        });
    }

    public void noTransication(){
        cityService.updateCity(null);
        int i = 1/0;
    }

    /**
     *
     */
    public void programTransication2() {
        //定义事物
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setReadOnly(true); //只读
        //事物隔离级别
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Boolean aBoolean = cityService.updateCity(null);
            int i = 1 / 0;
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            logger.error("事物异常:{}",e.getMessage());
        }
    }


    public void programTransication3() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, true);
            CityMapper mapper = sqlSession.getMapper(CityMapper.class);
            mapper.updateName();
            int i = 1/0;
            sqlSession.commit();
        }catch(Exception e){
              sqlSession.rollback(true);
              logger.error("数据回滚:{}", e);
        }finally {
            if (null != sqlSession) {
                sqlSession.clearCache();
                sqlSession.close();
            }
        }
    }
}
