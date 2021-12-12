package program.SlidingWindow;

/**
 * @Author tangkai009
 * @Date 2021-04-14
 * @description
 */
public class MaxNoRepeatSub {


    public static void main(String[] args) {

//        Integer a = getMaxNoRepeatSub("aabcddf");

        Integer a = getMaxNoRepeatSub("pwwkew");
        System.err.println(a);
    }

    /**
     * Max No repeat sub
     * @param str
     * @return
     *
     * aabcddf   abcd
     */
    public static Integer getMaxNoRepeatSub(String str){

        int right = 0; int left = 0;
        int[] windows = new int[256];
        int res = 0;

        while(right < str.length()){
            int c = str.charAt(right);
            windows[c]++;
            right++;

            while(windows[c] > 1){
                int r = str.charAt(left);
                windows[r]--;
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
