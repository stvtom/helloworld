package program;

/**
 * @Author tangkai009
 * @Date 2021-04-14
 * @description
 */
public class MaxPalindrome {

    public static void main(String[] args) {

        String str = "abcdcbasadsfa";

        System.err.println(getMaxPalindrome(str));
    }

    /**
     * max hw
     * @param str
     * @return
     */
    public static String getPalindrome(String str,int l, int r){

        //Mark
        if (str.charAt(l) != str.charAt(r)){
            return str.charAt(r)+"";
        }
        while(l >= 0 && r < str.length() &&
                //Mark
                str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l+1,r);
    }

    public static String getMaxPalindrome(String str){

        String res = "";
        for (int i = 0; i < str.length() - 1 ; i++) {

            String even = getPalindrome(str, i, i);
            String odd = getPalindrome(str,i,i+1);
            res = res.length() > even.length() ? res:even;

            res = res.length() > odd.length() ? res:odd;
        }
        return res;
    }
}
