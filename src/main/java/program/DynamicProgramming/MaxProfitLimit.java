package program.DynamicProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-20
 * @description
 */
public class MaxProfitLimit {


    public static void main(String[] args) {

        int[] nums = new int[]{7,1,5,3,6,4};

        System.err.println(getMaxProfitHasFee(nums,1));

    }

    /**
     * has Fee
     * @param nums
     * @param k
     * @return
     */
    public static Integer getMaxProfitHasFee(int[]nums,int k){

        if (nums.length < 2){
            return 0;
        }
        int[]buy = new int[nums.length];

        int[]sell = new int[nums.length];

        buy[0] = -nums[0];

        for (int i = 1; i < nums.length ; i++) {

            buy[i] = Math.max(buy[i-1],sell[i-1]-nums[i]);

            sell[i] = Math.max(buy[i-1]+nums[i]-k,sell[i-1]);
        }
        return sell[nums.length-1];
    }

    /**
     * has limit
     * @param nums
     * @param k
     * @return
     */
    public static Integer getMaxProfitHasLimit(int[]nums,int k){

        if (nums.length < 2){
            return 0;
        }



        return 0;
    }

}
