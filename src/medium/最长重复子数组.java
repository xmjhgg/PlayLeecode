package medium;

import java.util.Arrays;

public class 最长重复子数组 {
    /**
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * <p>
     * 示例 1:
     * 输入:
     * A: [1,2,3,2,1]
     * B: [3,2,1,4,7]
     * 输出: 3
     * 解释:
     * 长度最长的公共子数组是 [3, 2, 1]。
     */

    //暴力法,超时
    public static int longestSubArr1(int[] A, int[] B) {
        int maxlen = 0;
        int[] ans = null;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int k = 0;
                while (A[i + k] == B[j + k]) {
                    k++;
                    if (i + k == A.length || j + k == B.length) break;
                }
                maxlen = Math.max(maxlen, k);
            }
        }
        return maxlen;
    }

    /**
     * 动态规划
     * 暴力法超时的原因在于，以A{1,2,4}和B{1,2,5}为例，其中A[2]和B[2]比较了3次
     * 动态规划则将每次比较的结果保存起来，避免了多次重复的比较
     * dp[i][j]中,i j就是A[i:] B[j:] 后续数组的最长子串的长度
     */
    public static int longestSubArr2(int[] A, int[] B) {
        int maxlen = 0;
        int n = A.length;
        int m = B.length;
        //这里加1的原因是需要在下面的代码中需要用到i+1,j+1，避免越界
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1]+1 : 0;
                maxlen=Math.max(maxlen,dp[i][j]);
            }
        }
        return maxlen;
    }

    /**
     * 滑动窗口法
     */
    public int findLength(int[] A, int[] B) {
        if (A.length < B.length)
            return findLengthHelper(A, B);
        return findLengthHelper(B, A);
    }

    public int findLengthHelper(int[] A, int[] B) {
        int aLength = A.length, bLength = B.length;
        //total是总共运行的次数
        int total = aLength + bLength - 1;
        int max = 0;
        for (int i = 0; i < total; i++) {
            //下面一大坨主要判断数组A和数组B比较的起始位置和比较的长度
            int aStart = 0;
            int bStart = 0;
            int len = 0;
            if (i < aLength) {
                aStart = aLength - i - 1;
                bStart = 0;
                len = i + 1;
            } else {
                aStart = 0;
                bStart = i - aLength + 1;
                len = Math.min(bLength - bStart, aLength);
            }
            int maxlen = maxLength(A, B, aStart, bStart, len);
            max = Math.max(max, maxlen);
        }
        return max;
    }

    //计算A和B在上面图中红色框内的最大长度
    public int maxLength(int[] A, int[] B, int aStart, int bStart, int len) {
        int max = 0, count = 0;
        for (int i = 0; i < len; i++) {
            if (A[aStart + i] == B[bStart + i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(longestSubArr2(nums1, nums2));
    }
}
