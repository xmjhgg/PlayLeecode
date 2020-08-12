package simple;

public class 盛最多水的容器 {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49(7*7)
     */


    public static int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=-1;
        while(left<right){
            int len=right-left;
            max=Math.max((len*Math.min(height[left],height[right])),max);
            if (height[left]<height[right]){
                left++;
            }else if (height[left]>height[right]){
                right--;
            }else {
                left++;
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height=new int[]{2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
}
