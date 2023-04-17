package program.LeetCode;

/**
 * @Author tangkai009
 * @Date 2023-04-13
 * @description
 * 无重复字符的最长子串
 */
public class L03lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int rigth = 0 ;
        int left = 0;
        int max =  0;
        int[] arr = new int[300];
        while(rigth < s.length()){
            char c = s.charAt(rigth);
            arr[c] = arr[c] + 1;
            rigth++;
            while(arr[c] > 1 && left < rigth){
                char r = s.charAt(left);
                arr[r] -- ;
                left++;
            }
            max = Math.max(rigth-left,max);
        }
        return max;
    }
}
