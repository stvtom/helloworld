package core.keyWords;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangkai009
 * @Date 2021-11-03
 * @description
 *
 * 泛型
 * https://www.cnblogs.com/lwbqqyumidi/p/3837629.html
 */
public class Generic {

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("A");
        list.add(1);

        for (int i = 0;i<list.size();i++){
            String s = (String) list.get(i);
            System.err.println(s);
        }

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        //会报错
//        list1.add(1);
    }
}
