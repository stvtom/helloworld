package program.LeetCode;

import java.util.HashMap;

/**
 * @Author tangkai009
 * @Date 2023-04-12
 * @description
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target
 * 的那 两个 整数，并返回它们的数组下标。
 */
public class L01TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0 ;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0 ;i < nums.length; i++){
            if(map.containsKey(target-nums[i])&& map.get(target-nums[i]) != i){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[]{-1,-1} ;
    }

}
