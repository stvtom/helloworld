package program.SomeProgram;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tangkai009
 * @Date 2021-11-10
 * @description
 * 有两个字符串 A、B，要查询A在B中出现的次数，以及首次和末次出现索引位置
 * 例子：
 *    A=”addfffdf ll",B="dff"
 *    则B在A出现1次，索引位置2
 */
public class demo3 {

    public static Map<String,Integer> getSub(String str1,String str2){
        int count = 0;
        int first = -1 ;
        int last = -1 ;
        for (int i = 0; i < str1.length()-str2.length(); i++) {
            String substring = str1.substring(i, str2.length());
            if (substring.equals(str2)){
                count++;
                if (first != -1){
                    first = i;
                }
                last = i;
            }
        }

        Map<String,Integer> map = new HashMap<>();

        map.put("count",count);
        map.put("first",first);
        map.put("last",last);
        return map;
    }
}
