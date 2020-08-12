package simple;

public class 计数二进制子串 {
    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     *
     * 重复出现的子串要计算它们出现的次数。
     *
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     *
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     */

    /**
     * 解析发现 每个01组成的子字符串可以组成 Min(0的数量，1的数量) 个相同数量的01子字符串;
     */
    public static int countBinarySubstrings(String s) {
        int start = 0 , end = s.length() , preCount = 0;
        int ans = 0;

        while (start < end ){
            char curChar = s.charAt(start);
            int count = 0;
            while (start<end && s.charAt(start)==curChar){
                start++;
                count++;
            }
            ans += Math.min(count,preCount);
            preCount = count;

        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(countBinarySubstrings(s));
    }
}
