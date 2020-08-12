package medium;

public class 长度最小的子数组 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     * <p>
     * 示例:
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */

    /**
     * 双指针，两个指针最多遍历n次
     *
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int start=0,end=0;
        int ans=Integer.MAX_VALUE;
        int sum=0;
        while (end<nums.length){
            sum+=nums[end];
            while (sum>=s){
                ans=Math.min(ans,end-start+1);
                sum-=nums[start++];
            }
            end++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
