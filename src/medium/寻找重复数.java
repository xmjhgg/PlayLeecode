package medium;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 寻找重复数 {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
     * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 说明：
     *  不能更改原数组（假设数组是只读的）。
     *  只能使用额外的 O(1) 的空间。
     *  时间复杂度小于 O(n2) 。
     *  数组中只有一个重复的数字，但它可能不止重复出现一次。
     */


    /**
     * 思路是用二分查找，找出重复的数值是多少
     * 在一个不包含重复数的1到n的数组，遍历整个数组，小于等于中位数的元素一定等于中位数
     * 如果存在一个重复的元素，那么如果小于等于中位数的元素 小于等于 中位数，那么重复元素的数值就一定在中位数的右侧
     * 反之，如果小于等于中位数的元素 大于 中位数，那么重复元素的数值就一i的那个在中位数的左侧（包含中位数）
     */
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len -1;

        while (left<right){

            int count = 0;
            int mid = (left+right)/2;

            for (int num : nums) {
                if (num<=mid) count++;
            }

            if (count>mid){
                right = mid;
            }else {
                left = mid+1;
            }

        }


        return left;
    }

    public static void main(String[] args) throws ParseException {
        int[] nums = {1,3,4,2,2};

        System.out.println(findDuplicate(nums));

    }
}
