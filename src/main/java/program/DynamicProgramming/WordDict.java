package program.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 * 单词拆分
 * https://blog.csdn.net/m0_37605197/article/details/107580468
 *
 * 输入: s = “applepenapple”, wordDict = [“apple”, “pen”]
 * 输出: true
 * 解释: 返回 true 因为 “applepenapple” 可以被拆分成 “apple pen apple”。
 * 注意你可以重复使用字典中的单词。
 */
public class WordDict {

    public static void main(String[] args) {

    }

    /**
     * 思路：字符串的从0-j的路径满足要求，如果j-i的路基也满足单词，则dp[j]满足要求
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}