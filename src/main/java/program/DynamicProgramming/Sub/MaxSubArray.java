package program.DynamicProgramming.Sub;

/**
 * 连续子串的最大值
 * @Author tangkai009
 * @Date 2021-04-14
 * @description
 */
public class MaxSubArray {

    public static void main(String[] args) {

//        int[]nums = new int[]{-1,3,-2,4,-1,5,-10,11};
        int[]nums = new int[]{-1,3,-2,4,-1,5,-10};

        System.err.println(maxSubArray(nums));
    }


    /**
     * lianxu  sub  max sum
     * @param nums
     * @return
     */
    public static Integer maxSubArray(int[]nums){

        int[]dp = new int[nums.length];
        dp[0] = nums[0];

        int res = 0;
        for (int i = 1; i < nums.length; i++) {

            dp[i] = Math.max(nums[i]+dp[i-1],nums[i]);
        }

        for (int i = 0; i < dp.length; i++) {

            if (res < dp[i]){
                res = dp[i];
            }
        }
        return res;
    }
}
