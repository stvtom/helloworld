package program;

import java.util.*;

/**
 * @Author tangkai009
 * @Date 2021-04-14
 * @description
 */
public class ThridSum {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        List<Integer> arrayList = new ArrayList<>(integerList);

//        List<TreeSet<Integer>> secondSum = getSecondSum(arrayList, 10);
//        System.err.println(secondSum);
        System.err.println(getThirdSum(arrayList,10));

    }

    /**
     * three sum
     * @param nums
     * @param target
     * @return
     */
    public static List<TreeSet<Integer>> getThirdSum(List<Integer>nums,Integer target){

        Collections.sort(nums);

        List<TreeSet<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {

            List<Integer> array = nums;

            Integer removeData = array.remove(i);
            List<TreeSet<Integer>> secondSum = getSecondSum(array, target - removeData);

            secondSum.forEach(
                    e->{
                        e.add(removeData);
                    }
            );
            listList.addAll(secondSum);
        }
        return listList;
    }


    public static List<TreeSet<Integer>> getSecondSum(List<Integer>nums,Integer target){

//        Collections.sort(nums);

        List<TreeSet<Integer>> listList = new ArrayList<>();

        int left = 0; int right = nums.size()-1;

        //Mark
        while(left < nums.size() && right >= 0 && left < right){

            int sum = nums.get(left) + nums.get(right);

            if (sum < target){
                left++;
            }else if (sum > target){
                right--;
            }else if (sum == target){
                TreeSet<Integer> set = new TreeSet<>();

                set.add(nums.get(left));
                set.add(nums.get(right));
                listList.add(set);
                left++;
                right--;
            }
        }
        return listList;
    }
}
