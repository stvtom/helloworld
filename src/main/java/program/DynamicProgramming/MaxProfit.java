package program.DynamicProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-19
 * @description
 */
public class MaxProfit {


    public static void main(String[] args) {

        int[] nums = new int[]{7,1,5,3,6,4};

//        System.err.println(getMaxProfitByOneChange(nums));
//        System.err.println(getMaxProfitByOneChangeOfDynamic(nums));
        System.err.println(getMaxProfitByManyChange(nums));
    }


    /**
     * one change
     * @param nums
     * @return
     */
    public static Integer getMaxProfitByOneChange(int[]nums){
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                res = Math.max(res,nums[j]-nums[i]);
            }
        }
        return res;
    }

    /**
     * i 前的 min
     * @param nums
     * @return
     */
    public static Integer getMaxProfitByOneChangeOfDynamic(int[]nums){

        int length = nums.length;

        int res = 0;

        if(length < 2){
            return res;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }else {
                res = Math.max(res, nums[i] - min);
            }
        }
        return res;
    }

    /**
     * one more change
     *
     * mind：多个递增子串相加
     * @param nums
     * @return
     */
    public static Integer getMaxProfitByManyChange(int[]nums){

        int length = nums.length;
        int res = 0;
        if (length < 2){
            return res;
        }
        for (int i = 1; i < length; i++) {
            res += Math.max(0,nums[i]-nums[i-1]);
        }
        return res;
    }
}
