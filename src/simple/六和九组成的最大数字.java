package simple;

public class 六和九组成的最大数字 {
    /**
     * 给你一个仅由数字 6 和 9 组成的正整数 num。
     * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
     * 请返回你可以得到的最大数字。
     */
    public static int maximum69Number (int num) {
        int length=0;
        for (int i=num;i>0;i/=10){
            length++;
        }
        int temp=num;
        for (int i = (int) Math.pow(10,length-1);length>0;i/=10,length--){
            if (temp/i==6){
                    num+=3*Math.pow(10,length-1);
                break;
            }
            temp-=temp/i*Math.pow(10,length-1);
        }
        return num;
    }

    public static void main(String[] args) {
        int num=9996;
        System.out.println(maximum69Number(num));
    }

}
