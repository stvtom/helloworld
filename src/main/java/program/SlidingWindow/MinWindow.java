package program.SlidingWindow;

/**
 * @Author tangkai009
 * @Date 2021-04-14
 * @description
 */
public class MinWindow {

    public static void main(String[] args) {
        //
        String minSub = getMinSub("ADOBECODEBANC", "ABC");

//        String minSub = getMinSub("acbceef", "abce");

        System.err.println(minSub);
    }

    /**
     * min subString
     * @param str
     * @param sup
     * @return
     */
    //acbceef  //abce
    public static String getMinSub(String str,String sup){

        int right = 0; int left = 0;
        int[] windows  = new int[256];

        int[] needs = new int[256];

        int valid = 0;

        int validSize = 0;

        int start = 0; int len = Integer.MAX_VALUE;

        for (int i = 0; i < sup.length() ; i++) {
            int c = sup.charAt(i);
            windows[c]++;
            if (windows[c] == 1) {
                validSize++;
            }
        }

//        System.err.println(validSize);

        while(right < str.length()){

            int c = str.charAt(right);
            right++;
            needs[c]++;
            if (needs[c] == windows[c]){
                valid++;
            }
            while(valid == validSize){

                System.err.println("left:"+left + ", right:"+right);
                int r = str.charAt(left);
                if (right - left < len ){
                    start = left;
                    len = right - left;
                }
                left++;
                needs[r]--;
                //Mark  && windows[r] != 0
                if (needs[r] != windows[r] && windows[r] != 0){
                    valid--;
                }

            }
        }
        return str.substring(start,start+len);
    }
}
