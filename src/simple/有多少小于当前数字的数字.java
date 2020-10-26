package simple;

import java.util.Arrays;

public class 有多少小于当前数字的数字 {
    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     * 以数组形式返回答案。
     * 0 <= nums[i] <= 100


     * 示例 1：
     * 输入：nums = [8,1,2,2,3]
     * 输出：[4,0,1,1,3]
     * 解释：
     * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
     * 对于 nums[1]=1 不存在比它小的数字。
     * 对于 nums[2]=2 存在一个比它小的数字：（1）。
     * 对于 nums[3]=2 存在一个比它小的数字：（1）。
     * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
     *
     * 示例 2：
     * 输入：nums = [6,5,4,8]
     * 输出：[2,1,0,3]
     *
     * 示例 3：
     * 输入：nums = [7,7,7,7]
     * 输出：[0,0,0,0]
     */

    //暴力法
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            int l = 0;
            int r =nums. length;
            int index = i+1;
            int number = 0;

            while (i>l){
                if (nums[l]<nums[i]){
                    number++;
                }
                l++;
            }

            while (index < r){
                if (nums[index]<nums[i]){
                    number++;
                }
                index++;
            }

            ans[i] = number;

        }

        return ans;
    }

    //开辟另一个数组来存储小于当前数的数的个数
    public static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] cnt = new int[101];
        int[] ans = new int[nums.length];

        //此处遍历是保存nums中相同元素出现的个数
        for (int i = 0 ;i< nums.length;i++){
            cnt[nums[i]] ++;
        }

        //此处遍历保存了小于nums[i]数的个数 ，i-1对应的数就是小于i的数的个数
        for (int i = 1;i < cnt.length;i++){
            cnt[i] += cnt[i-1];
        }


        for (int i = 0;i < nums.length;i++){
            ans[i] = nums[i] == 0 ? 0 :cnt[nums[i]-1];
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {5,0,10,0,10,6};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent2(nums)));


    }
}
