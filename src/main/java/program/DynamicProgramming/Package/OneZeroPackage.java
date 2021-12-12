package program.DynamicProgramming.Package;

/**
 * 0 - 1 package
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class OneZeroPackage {

    public static void main(String[] args) {

        int[]wt = new int[]{2,1,3};

        int[]val = new int[]{4,2,3};

        System.err.println(knapsack(wt,val,3,4));

    }

    //wt [2,1,3]

    //val [4,2,3]   w 4 n 3
    public static Integer knapsack(int[]wt,int[]val,int n,int w){


        int[][]dp = new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= w ; j++) {

                if (j-wt[i-1] >= 0) {

                    //Mark  dp[i-1][j - wt[i - 1]] + val[i - 1]
                    //注意 dp[i-1]
                    dp[i][j] = Math.max(dp[i-1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }

//                System.err.print(i+","+j+","+dp[i][j]+"  ");
            }
//                System.err.println();

        }
        return dp[n][w];
    }
}
