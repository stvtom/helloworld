package program.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author tangkai009
 * @Date 2023-04-20
 * @description
 *
 * 滑动窗口的最大值
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L239MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {


        //边界处理
        if (k <= 1 || nums.length == 0){
            return nums;
        }

        //nums.length < k
        if (nums.length <= k){
            int max = 0 ;
            for (int i = 0; i < nums.length; i++) {

                max = Math.max(nums[i],max);
            }
            return new int[]{max};
        }

        //存储最大值元素
        LinkedList<Integer> indexDeque = new LinkedList<>();

        //存储最终结果集
        int[] arr = new int[nums.length - k + 1];

        int j = 0;

        // 初始化第一个滑动窗口的数值
        for (int i = 0; i < k - 1; i++) {
            while (!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            // 双端队列保存当前值的索引
            indexDeque.addLast(i);
        }
        // 处理其他的滑动窗口
        for (int i = k - 1; i < nums.length; i++) {
            while (!indexDeque.isEmpty() && nums[i] > nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            // 如果最大值不在滑动窗口时，进行移除
            if (i - indexDeque.getFirst() + 1 > k) {
                indexDeque.removeFirst();
            }
            // 将结果数组里添加队列第一个元素（即当前滑动窗口最大值）
            arr[j] = nums[indexDeque.getFirst()];
            j++;
        }
        return arr;
    }


    public static void main(String[] args) {


        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};

        int[] arr = maxSlidingWindow(ints, 3);

//        int[] ints = {9,10,9,-7,-4,-8,2,-6};
//
//        int[] arr = maxSlidingWindow(ints, 5);

        for (int i = 0; i < arr.length; i++) {
            System.err.println(arr[i]);
        }

    }
}
