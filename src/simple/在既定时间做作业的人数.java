package simple;

public class 在既定时间做作业的人数 {
    /**
     * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），
     * 并指定一个整数 queryTime 作为查询时间。
     * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
     * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，
     * 返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。

     * 示例 1：
     *
     * 输入：startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
     * 输出：1
     * 解释：一共有 3 名学生。
     * 第一名学生在时间 1 开始写作业，并于时间 3 完成作业，在时间 4 没有处于做作业的状态。
     * 第二名学生在时间 2 开始写作业，并于时间 2 完成作业，在时间 4 没有处于做作业的状态。
     * 第二名学生在时间 3 开始写作业，预计于时间 7 完成作业，这是是唯一一名在时间 4 时正在做作业的学生。
     */

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int ans=0;
        for(int i=0;i<startTime.length;i++){
            if (startTime[i]<=queryTime&&endTime[i]>=queryTime){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] st=new int[]{1,2,3};
        int[] et=new int[]{3,2,7};
        int query=4;
        System.out.println(busyStudent(st,et,query));

    }

}
