package simple;

public class 长按键入 {
    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     *
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     *
     示例 1：

     输入：name = "alex", typed = "aaleex"
     输出：true
     解释：'alex' 中的 'a' 和 'e' 被长按。

     示例 2：

     输入：name = "saeed", typed = "ssaaedd"
     输出：false
     解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。

     示例 3：

     输入：name = "leelee", typed = "lleeelee"
     输出：true

     示例 4：

     输入：name = "laiden", typed = "laiden"
     输出：true
     解释：长按名字中的字符并不是必要的。
     */

    public static boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0) return false;
        if (typed == null || typed.length() == 0) return false;

        int i = 0;
        int j = 0;

        if (name.charAt(i) != typed.charAt(j)) return false;

        while (i<=name.length()-1){

            if (name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else {
                    while (name.charAt(i) != typed.charAt(j)){
                        if (j>0){
                            if (typed.charAt(j)!=typed.charAt(j-1)) return false;
                        }
                        j++;
                        if (j>typed.length()-1){
                            return false;
                        }
                    }
                if (j == typed.length()-1 && typed.charAt(j) != name.charAt(i)) return false;
                }
            if (j == typed.length()-1 && i < name.length()-1) return false;
        }


        int end = typed.length()-2;
        while (j<=end){
            if (typed.charAt(j) != typed.charAt(j+1)){
                return false;
            }else {
                j++;
            }


        }

        return true;
    }

    public static void main(String[] args) {


//        String name = "pyplrz";
//        String type = "ppyypllr";

//        String name = "alex";
//        String type = "aalleexx";

        String name ="a";
        String type ="aaaaaaaaaaaaaaaaa";

//        String name ="alex";
//        String type = "alexxr";

//        String name = "alex";
//        String type = "aaleelx";

//        String name ="zlexya";
//        String type = "aazlllllllllllllleexxxxxxxxxxxxxxxya";

        System.out.println(isLongPressedName(name,type));


    }
}
