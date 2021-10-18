package program.DynamicProgramming.Sequence;

/**
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class IncrementSequence {

    public static void main(String[] args) {

        int[] nums = new int[]{1,4,3,4,2,3,5};
        int lengthOfLIS = lengthOfLIS(nums);

        System.err.println(lengthOfLIS);

    }

    // 1 4 3 4 5 2 3

    // 1 2 2 3 4 2 2
    //dp[i]
    //max increment sequence
    public static int lengthOfLIS(int[]nums){

        int [] dp = new int[nums.length];

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        // j = 0 ->i
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {

            if (res < dp[i]){
                res = dp[i];
            }
        }

        return res;
    }

}
