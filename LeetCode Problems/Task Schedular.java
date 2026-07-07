import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Hashtable<Character, Integer> table = new Hashtable<>();
        int max = 0, maxCount = 0;
        for(char each:tasks){
            table.put(each,table.getOrDefault(each, 0)+1);
            max = Math.max(max, table.get(each));
        }
        for(char key: table.keySet())if(table.get(key) == max) maxCount++;
        int processed = (max-1)*(n+1)+maxCount;
        return Math.max(processed, tasks.length);
    }
        
    }
