package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 只出现一次的数字 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    public static int singleNumber(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{4,1,2,1,2,4,5};
        System.out.println(singleNumber(arr));
        List<Integer> list=new ArrayList<>();
        list.add(null);

        list.add(null);
        list.add(1);
        System.out.println(list);
    }
}
