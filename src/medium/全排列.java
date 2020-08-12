package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列 {
    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int len=nums.length;
        boolean[] used=new boolean[len];
        List<Integer> path=new ArrayList<>();
        dfs(nums,len,0,path,used,ans);



        return ans;
    }

    private static void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> ans) {
        if (depth==len){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (!used[i]){
                used[i]=true;
                System.out.println("used:"+Arrays.toString(used));
                path.add(nums[i]);
                System.out.println("path:"+path);
                dfs(nums,len,depth+1,path,used,ans);//深入

                used[i]=false;//回溯

                path.remove(path.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列 solution = new 全排列();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }



}
