package servlet;

public class UserB implements UserBInterface {

    private String name = "张三";

    private Integer age = 18;

    public String address = "洪湖";

    private String sing(String name){
        System.err.println("UserB在唱歌"+ name);
        return name;
    }


    private Integer dance(Integer name){
        System.err.println("UserB在跳舞" + name);
        return name;
    }

    public String getName(String name) {

        System.err.println("这是一个接口的方法" + name);
        return name;
    }
}
