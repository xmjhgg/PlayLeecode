package medium;

import java.util.ArrayList;
import java.util.HashMap;

public class 最小路径和 {
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     * 示例:
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */

    /**
     * 使用动态规划dp,dp中每个元素的值都代表走到这一个方格中的最短路径和
     * 其中矩阵最左侧的一列只能是元素向下移动的路径,矩阵最上方的元素只能是向左移动的路径
     * 其他的矩阵则是 方格上方的路径和或者方格左方的路径两者中的最小值加上本身的矩阵
     * 根据这个规则得到的dp矩阵
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length==0||grid[0].length==0){
            return 0;
        }

        int row=grid.length;
        int col=grid[0].length;

        int[][] dp = new int[row][col];

        dp[0][0]=grid[0][0];
        for (int i=1;i<row;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }

        for (int i=1;i<col;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }


        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
