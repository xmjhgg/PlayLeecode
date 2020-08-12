package medium;

import java.util.Arrays;

public class 除自身以外数组的乘积 {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，
     * 返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] leftTimes=new int[nums.length];
        int[] rightTimes=new int[nums.length];
        int[] ans=new int[nums.length];

        leftTimes[0]=1;//left是索引i左侧所有元素的乘积，在0索引处的左侧没有乘积 所以设为1
        rightTimes[rightTimes.length-1]=1;//right同理
        for (int i=1;i<nums.length;i++){
            leftTimes[i]=nums[i-1]*leftTimes[i-1];
        }

        for (int i=rightTimes.length-2;i>=0;i--){
            rightTimes[i]=nums[i+1]*rightTimes[i+1];
        }


        for (int i=0;i<nums.length;i++){
            ans[i]=leftTimes[i]*rightTimes[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }


}
