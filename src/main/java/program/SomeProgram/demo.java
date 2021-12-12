package program.SomeProgram;


import java.util.List;

/**
 * @Author tangkai009
 * @Date 2021-11-03
 * @description
 */
public class demo {

    /**
     * 输入整数数组 []
     *
     * 调整数据的顺序
     *
     * 把所有的基数放在前半部分  偶数放在后半部分
     */

    public List<Integer> getList(List<Integer>nums){

        int len = nums.size();
        if (len <= 1){
            return nums;
        }
        for (int i=0 ;i< len-1 ;i++){
            int i1 = nums.get(i) % 2;
            int i2 = nums.get(i + 1) % 2;
            if ( i1 == 0 && i2 != 0){
                Integer flag = nums.get(i1);
                nums.set(i1,nums.get(i2));
                nums.set(i2,flag);
            }
        }
        return nums;
    }


    public List<Integer> getList2(List<Integer>nums){
        int len = nums.size();
        if (len <= 1){
            return nums;
        }
        //左指针
        int i = 0 ;
        //右指针
        int j = len-1  ;
        while (i < j){
            int i1 = nums.get(i) % 2;
            int i2 = nums.get(j) % 2;
            //i1是偶数  i2是基数
            if (i1 == 0 && i2 == 1){
                Integer flag = nums.get(i1);
                nums.set(i1,nums.get(i2));
                nums.set(i2,flag);
                i1++;
                i2--;
                continue;
            }
            if (i1 == 1){
                i1++;
            }
            if (i2 == 0){
                j--;
            }
        }
        return nums;
    }

}
