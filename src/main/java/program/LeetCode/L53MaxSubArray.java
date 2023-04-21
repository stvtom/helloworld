package program.LeetCode;

import javax.validation.constraints.Max;

/**
 * @Author tangkai009
 * @Date 2023-04-22
 * @description
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class L53MaxSubArray {

    public int maxSubArray(int[] nums) {


        //dp[i] = max{nums[i],dp[i-1]+nums[i]}

        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
        }

        int max = Integer.MIN_VALUE ;

        for (int i = 0; i < dp.length; i++) {

            max = Math.max(dp[i],max);
        }

        return max;
    }
}
