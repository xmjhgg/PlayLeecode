package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 根据字符出现频率排序 {
    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * 示例 :
         * 输入:
         * "tree"
         * 输出:
         * "eert"
         * 解释:
         * 'e'出现两次，'r'和't'都只出现一次。
         * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     */

    public static String frequencySort(String s) {
            StringBuilder ans=new StringBuilder();
            int[] letters=new int[128];
            for (Character c:s.toCharArray()){
                letters[c]++;
            }

            PriorityQueue<Character> heap=new PriorityQueue<>((a,b)->Integer.compare(letters[b],letters[a]));

            for (int i=0;i<letters.length;i++){
                if (letters[i]!=0) heap.offer((char)i);
            }

            while (!heap.isEmpty()){
                char c=heap.poll();
                while (letters[c]-->0){
                    ans.append(c);
                }
            }
            return ans.toString();
        }


    public static void main(String[] args) {
        String s="tree";
        System.out.println(frequencySort(s));
    }
}
