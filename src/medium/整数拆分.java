package medium;

import java.util.ArrayList;

public class 整数拆分 {
    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * 示例 1:
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     *
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * 说明: 你可以假设 n 不小于 2 且不大于 58。
     */

    /**
     *动态规范法
     * dp[i] 的值为 i拆分后的最大乘机
     * 那么对应的每个i在拆分成拆j,i-j后，有两种情况
     * 1.i-j 可以继续拆分，那么此时的dp[i]的最大乘机就是 j*dp[i-j]
     * 2.i-j 不能继续拆分，此时的dp[i]最大乘机就是j*(i-j)
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n+1]; //因为数组下标存在 不存在的正整数0的情况，所以长度得+1;

        for (int i =2;i<=n;i++){
            int curMax = 0;
            for (int j=1;j<i;j++){
                curMax=Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curMax;
        }

        return dp[n];
    }
    /**
     * 动态规划优化
     * 通过数学验证，当正整数尽可能的拆分成3时，此时的乘积最大，其次是2
     * 因此，可以不用再多循环一次判断每个正整数的每种拆分情况，只需要考虑正整数的拆分出来的j为3和2的情况
     */
    public static int integerBreak2(int n) {
        int[] dp = new int[n+1];
        dp[2]=1;
        for (int i =3;i<=n;i++){
            dp[i] = Math.max(Math.max(3*(i-3),3*dp[i-3]),Math.max(2*(i-2),2*dp[i-2]));
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

}
