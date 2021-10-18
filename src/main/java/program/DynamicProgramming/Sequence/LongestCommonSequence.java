package program.DynamicProgramming.Sequence;

/**
 * @Author tangkai009
 * @Date 2021-04-15
 * @description
 */
public class LongestCommonSequence {

    public static void main(String[] args) {

        Integer commonSequence = longestCommonSequence("zabcde", "acez");

        System.err.println(commonSequence);

    }

    //Longest Common Subsequence

    //zabcde acez  == ace
    public static Integer longestCommonSequence(String s1,String s2){

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length() ; i++) {

            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
