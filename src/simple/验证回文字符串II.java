package simple;

public class 验证回文字符串II {
    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 示例 1:
     *
     * 输入: "aba"
     * 输出: True
     */

    public static boolean validPalindrome(String s) {
        int left=0,right=s.length()-1;
        boolean ans=true;
        while (left<right){
            System.out.println(s.charAt(left)+","+s.charAt(right));
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                boolean lFlag=true,rFlag=true;
                for (int i=right-1,j=left;i>j;i--,j++){
                    System.out.println("进入删除右侧字符流程："+s.charAt(j)+","+s.charAt(i));
                    if (s.charAt(i)!=s.charAt(j)){
                        System.out.println("右侧不等");
                        lFlag=false;
                        break;
                    }
                }

                for (int i=left+1,j=right;i<j;i++,j--){
                    System.out.println("进入删除左侧字符流程："+s.charAt(i)+","+s.charAt(j));
                    if (s.charAt(i)!=s.charAt(j)){
                        System.out.println("左侧不等");
                        rFlag=false;
                        break;
                    }
                }
                return lFlag||rFlag;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a="eccer";
        System.out.println(validPalindrome(a));
    }


}
