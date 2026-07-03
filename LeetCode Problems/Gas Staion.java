import java.util.*;
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tottank=0,cartank=0,ista=0;
        for(int index=0;index<gas.length;index++){
            tottank+=gas[index]-cost[index];
            cartank+=gas[index]-cost[index];
            if(cartank<0){
                cartank=0;
                ista=index+1;
            }
        }
        return tottank>=0?ista:-1;
        
    }
}
