package program;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @Author tangkai009
 * @Date 2021-04-23
 * @description
 */
public class PrintMatrix {


    public static void main(String[] args) {

        int[][]nums = new int[2][3];
        nums[0][0] = 1;nums[0][1] = 2;nums[0][2] = 3;
        nums[1][0] = 4;nums[1][1] = 5;nums[1][2] = 6;
//        nums[2][0] = 7;nums[2][1] = 8;nums[2][2] = 9;

        ArrayList<Integer> arrayList = printArray(nums);


        System.err.println(arrayList);


    }

    public static ArrayList<Integer> printArray(int[][]nums){

        ArrayList<Integer> arrayList = new ArrayList<>();

        int col = nums[0].length;
        int row = nums.length;

        //行
        int colBegin = 0;

        int colEnd = col - 1;

        //列
        int rowBegin = 0;

        int rowEnd = row - 1;

        while (arrayList.size()!= row*col){
            //右
            for (int i = colBegin; i <= colEnd; i++) {
                arrayList.add(nums[rowBegin][i]);
            }
            //下
            for (int i = rowBegin+1; i <= rowEnd; i++) {
                arrayList.add(nums[i][colEnd]);
            }
            //右
            for (int i = colEnd-1; i >= colBegin ; i--) {
                arrayList.add(nums[rowEnd][i]);
            }
            //上
            for (int i = rowEnd -1; i > rowBegin; i--) {

                arrayList.add(nums[i][colBegin]);
            }
            //行++ --
            colBegin++;

            colEnd--;
            //列++ --
            rowBegin++;
            rowEnd--;
        }

        return arrayList;
    }
}
