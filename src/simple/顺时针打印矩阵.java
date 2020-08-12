package simple;

import java.util.Arrays;

public class 顺时针打印矩阵 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * 示例：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
         1 2  3  4
         5 6  7  8
         9 10 11 12
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0){
            return new int[0];
        }
        int index=0;;
        int deraction=1; //1右，2下，3左，4上;
        int minRow=0;
        int maxRow2=matrix.length;
        int maxRow=matrix.length-1;
        int minCol=0;
        int maxCol=matrix[0].length-1;
        int maxCol2=matrix[0].length;
        int[] ans=new int[maxRow2*maxCol2];

        while (index<ans.length){
            switch (deraction){
                case 1:
                    for (int i=minCol;i<maxCol+1;i++){
                            ans[index]=matrix[minRow][i];
                            index++;
                    }
                    minRow++;
                    deraction=2;
                    break;
                case 2:
                    for (int i=minRow;i<maxRow+1;i++){
                            ans[index]=matrix[i][maxCol];
                            index++;
                    }
                    maxCol--;
                    deraction=3;
                    break;
                case 3:
                    for (int i=maxCol;i>=minCol;i--){
                            ans[index]=matrix[maxRow][i];
                            index++;
                    }
                    maxRow--;
                    deraction=4;
                    break;
                case 4:
                    for (int i=maxRow;i>=minRow;i--){
                            ans[index]=matrix[i][minCol];
                            index++;
                    }
                    minCol++;
                    deraction=1;
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix={{2,5},{8,4},{0,-1}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

}
