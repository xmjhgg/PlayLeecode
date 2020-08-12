package medium;

public class 最长回文字符串 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */
    //中心扩散法：时间复杂度O n^2
    public static String longestPalindrome(String s) {
        if (s.length()==0){
            return "";
        }

        int maxStart=0;
        int maxEnd=0;
        int maxLne=0;
        for (int i=0;i<s.length();i++){
            int left=i-1;
            int right=i+1;
            int len=1;

            while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }

            while (left>=0&&s.charAt(left)==s.charAt(i)){
                left--;
                len++;
            }

            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                len+=2;
                left--;
                right++;
            }

            if (len>maxLne){
                maxLne=len;
                maxStart=left;
                maxEnd=right;
            }


        }

        return s.substring(maxStart+1,maxEnd);
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度


        boolean[][] dp = new boolean[strLen][strLen];
        //两边向中心扩散
        for (int r = 1; r < strLen; r++) {

            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                        System.out.println("分割点"+r);
                        System.out.println("截取后的字符串："+s.substring(maxStart,maxEnd+1));
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);

    }

    //动态规划 时间最差复杂度O n^2，最好O n
    public String longestPalindrome3(String s){
        boolean[][] dp=new boolean[s.length()][s.length()];
        int maxStart=0;
        int maxEnd=0;
        int maxLen=0;

        for (int right=1;right<s.length();right++){
            for (int left=0;left<right;left++){
                if (s.charAt(right) == s.charAt(left)&&(right-left<=2||dp[left+1][right-1])){

                }
            }
        }





        return null;
    }


    public static void main(String[] args) {
        String s="abaaba";
        System.out.println(longestPalindrome2(s));
    }
}
