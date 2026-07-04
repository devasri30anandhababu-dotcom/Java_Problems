import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int each:nums){
            int temp = map.getOrDefault(each,0)+1;
            map.put(each,temp);
        }
        List<Map.Entry<Integer,Integer>> tempList=new ArrayList<>(map.entrySet());
        tempList.sort(Map.Entry.comparingByValue());
        Collections.reverse(tempList);
        int [] result=new int[k];
        for(int index=0;index<k;index++)
        result[index]=tempList.get(index).getKey();
        return result;
    }
}
