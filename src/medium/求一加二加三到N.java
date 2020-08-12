package medium;

public class 求一加二加三到N {
    /**
     * 求 1+2+...+n ，
     * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 示例 1：
     *
     * 输入: n = 3
     * 输出: 6
     */

    /**
     * 解法:
     * 题目作了很多限制，循环不让使用，因此用递归来代替循环加法，if不让使用，因此使用了一个 &&的短路效果 来作为递归的条件判断
     * &&短路：当&&前的判断语句结果为false时，后面的的判断将不会执行
     */
    public static int sumNums(int n) {
        boolean x =n>0&&(n+=sumNums(n-1))>0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(4));
    }
}
