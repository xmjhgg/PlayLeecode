package simple;

public class 解码字母到整数的映射 {
    /**
     * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
     *
     *     字符（'a' - 'i'）分别用（'1' - '9'）表示。
     *     字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
     *
     * 返回映射之后形成的新字符串。
     * 题目数据保证映射始终唯一。
     */

    public static String freqAlphabets(String s) {
        String ans="";
        for (int i=0;i<s.length();i++){
            if (i+2<s.length()&&s.charAt(i+2)=='#'){
                ans+=(s.charAt(i)+s.charAt(i+1)+'a'-1);

            }else{
                ans+=(s.charAt(i)+'a'-1);
            }
        }


        return ans;
    }


    public static void main(String[] args) {

        System.out.println('a'+0);

        String a="10#11#12";
        System.out.println(freqAlphabets(a));

    }

}
