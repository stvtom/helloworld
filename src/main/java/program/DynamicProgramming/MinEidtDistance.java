package program.DynamicProgramming;

/**
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class MinEidtDistance {


    public static void main(String[] args) {

        Integer num = minEidtDistance("horse", "ros");

        System.err.println(num);
    }
    //min edit distance

    //horse ros
    //intention execution
    public static Integer minEidtDistance(String s1,String s2){

        //dp[1][1] = 1  dp[2][2] = 1
        //dp[1][2]

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i ;
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= s1.length(); i++) {

            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //insert、 adjust、 delete
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
