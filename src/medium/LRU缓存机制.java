package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRU缓存机制 {
    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
     * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；
     * 如果密钥不存在，则插入该组「密钥/数据值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

     * 进阶:
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     * 示例:
     *
     *LRUCache cache = new LRUCache( 2  缓存容量)  ;
     *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // 返回  1
     *cache.put(3,3);    // 该操作会使得密钥 2 作废
     *cache.get(2);       // 返回 -1 (未找到)
     *cache.put(4,4);    // 该操作会使得密钥 1 作废
     *cache.get(1);       // 返回 -1 (未找到)
     *cache.get(3);       // 返回  3
     *cache.get(4);       // 返回  4
     */


    /**
     * 解决：
     * 设置两个Map：dataMap和countMap,其中 dataMap用来存储数据，countMap用来计算dataMap中Key的使用频率，put动作两者同步
     * 在get和put dataMap中有的key时，countMap对应key的Value+1
     * 在put时如果dataMap中不存在这个key 并且dataMap的容量已经等于size了，那么就遍历countMap，找出value最小的key 将key移除，再put新的key
     */
    Map<Integer,Integer> dataMap;
    Map<Integer,Integer> countMap;
    Integer size;

    public LRU缓存机制(int capacity) {
        dataMap=new HashMap<>();
        countMap=new HashMap<>();
        size=capacity;
    }

    public int get(int key) {
        if (dataMap.get(key)!=null){
            for (Map.Entry<Integer,Integer> entry:countMap.entrySet()){
                if (entry.getKey()==key){
                    entry.setValue(entry.getValue()+1);
                }else {
                    entry.setValue(entry.getValue()-1);
                }
            }
            return dataMap.get(key);
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (dataMap.containsKey(key)){
            dataMap.put(key,value);
            countMap.put(key,countMap.get(key)+1);
        }else {
            if (dataMap.size()==size){

                int minValue=Integer.MAX_VALUE;
                int minKey=-1;
                for (Map.Entry<Integer,Integer> entry:countMap.entrySet()){
                    if (minValue>entry.getValue()){
                        minKey=entry.getKey();
                        minValue=entry.getValue();
                    }
                }
                dataMap.remove(minKey);
                countMap.remove(minKey);

            }
            dataMap.put(key,value);
            countMap.put(key,1);

        }


    }

    @Override
    public String toString() {
        return "LRU缓存机制{" +
                "dataMap=" + dataMap +
                ", countMap=" + countMap +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        LRU缓存机制 map=new LRU缓存机制(2);

        map.put(1,1);
        map.put(2,2);
        map.get(1);
        map.put(3,3);
        map.get(2);
        map.put(4,4);
        System.out.println(map);
        map.get(1);
        map.get(3);
        map.get(4);


    }
}
