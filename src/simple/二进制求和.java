package simple;

public class 二进制求和 {
    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * 输入为 非空 字符串且只包含数字 1 和 0。

     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        //倒序遍历
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            //如何两个字符串长度不等的话，就将短的作为0
            //利用在ASCII中 char 1和 char 0 两者的值相差1，将字符串转换为整形
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2); //用取余操作，将2转换为0，1还是1，0还是0
            ca = sum / 2; //ca是进数，如果sum是2，ca为1 进1，1、0都是0
        }
        sb.append(ca == 1 ? ca : ""); //最后再加上最后一次计算的ca
        return sb.reverse().toString();//倒序遍历，需要翻转字符串
    }

    public static void main(String[] args) {
        String a="11";
        String b="1";
        System.out.println(addBinary(a,b));
    }
}
