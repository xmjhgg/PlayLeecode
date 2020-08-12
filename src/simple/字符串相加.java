package simple;

public class 字符串相加 {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * 注意：
     *
     *     num1 和num2 的长度都小于 5100.
     *     num1 和num2 都只包含数字 0-9.
     *     num1 和num2 都不包含任何前导零。
     *     你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     */

    /**
     * 解法：
     * 将字符串拆分成char ，根据ASCII值转换成数字 其中0的ASC值为48，1为49，每个0-9每个数字递加1
     */
    public static String addStrings(String num1, String num2) {
        int i=num1.length()-1, j=num2.length()-1;

        StringBuilder ans = new StringBuilder();
        int add=0;
        while (i>=0||j>=0||add>0){
            int theNum = add;
            if (add == 1){
                add=0;
            }
            int a = i>=0? num1.charAt(i) - '0' : 0;
            int b = j>=0? num2.charAt(j) - '0' : 0;
            if (theNum+a+b>9){
                add=1;
                theNum = a+b+theNum -10;
            }else {
                theNum += a+b;
            }
            ans.append(theNum);
            i--;
            j--;
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "9";
        String b = "99";
        System.out.println(addStrings(a,b));
    }
}
