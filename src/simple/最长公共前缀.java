package simple;

public class 最长公共前缀 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     */

    public static String longestCommonPrefix(String[] strs) {
        int index=0;
        StringBuilder ans=new StringBuilder();
        Character tempC=null;
        int len=0;

        for (String s:strs){
            len=Math.max(s.length(),len);
        }

        while (index<len){
            if (index<strs[0].length()){
                tempC=strs[0].charAt(index);
            }else {
                return ans.toString();
            }
            boolean flag=true;
            for (int i=1;i<strs.length;i++){
                Character currentC=null;
                if (index<strs[i].length()){
                    currentC=strs[i].charAt(index);
                }else {
                    return ans.toString();
                }

                if (!currentC.equals(tempC)){
                    flag=false;
                }
            }
            if (flag){
                ans.append(tempC);
            }else {
                return ans.toString();
            }
            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] str={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }


}
