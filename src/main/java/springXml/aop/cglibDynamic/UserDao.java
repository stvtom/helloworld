package springXml.aop.cglibDynamic;

/**
 * CGlib动态代理实战
 * https://blog.csdn.net/top_code/article/details/50237771
 */
public class UserDao {

    public long insert() {
        System.out.println("insert() is executing !");
        return 1;
    }

    public void query() {
        System.out.println("query() is executing !");
    }

    public int update() {
        System.out.println("update() is executing !");
        return 1;
    }

    public int delete() {
        System.out.println("delete() is executing !");
        return 1;
    }
}
