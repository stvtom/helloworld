package program.DynamicProgramming.Package;

/**
 * complete package
 *
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class CompleteChange {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,5};

        Integer num = completeChange(nums, 5);

        System.err.println(num);

    }

    //1 2 5  = 4

    //dp[1][1] = 1 dp[1][2] = 2
    public static Integer completeChange(int[]nums,int traget){

        int[][] dp = new int[nums.length+1][traget+1] ;

        for (int i = 0; i <= nums.length ; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= nums.length ; i++) {

            for (int j = 1; j <= traget; j++) {
                //Mark >= 0
                if (j-nums[i-1] >= 0){
                    dp[i][j] = dp[i][j-nums[i-1]]+dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
//                System.err.print(i+","+j+","+dp[i][j]+"  ");
            }
//            System.err.println();
        }
        return dp[nums.length][traget];
    }
}
