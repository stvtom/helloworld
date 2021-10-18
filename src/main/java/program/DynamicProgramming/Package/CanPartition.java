package program.DynamicProgramming.Package;

import java.util.Arrays;

/**
 * part package
 *
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class CanPartition {

    public static void main(String[] args) {

//        int[]nums = new int[]{1,5,5,13};
        int[]nums = new int[]{3 ,7, 4, 6,4};

        System.err.println(canPartition(nums));

    }

    // 1 5 5 11

    // 3 7 4 6
    public static Boolean canPartition(int[]nums){

        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        int n = total / 2;

        boolean[][] dp = new boolean[n+1][nums.length+1];

        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= nums.length; j++) {

                //Mark > 0
                if (i-nums[j - 1] > 0) {
                    dp[i][j] = dp[i - nums[j - 1]][j] || dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
//                System.err.print(i+","+nums[j-1]+","+dp[i][j]+ " ");
            }

//            System.err.println();

        }
        return dp[n][nums.length];
    }
}
