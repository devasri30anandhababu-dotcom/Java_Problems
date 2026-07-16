import java.util.*;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist [src]=0;
        for(int index=0;index<=k;index++){
            int[]copy=Arrays.copyOf(dist,n);
            for(int[] each:flights){
                int cs=each[0], cd=each[1], cost=each[2];
                if(dist[cs]!=Integer.MAX_VALUE && (dist[cs]+cost)<copy[cd])
                copy [cd]=dist[cs]+cost;          
            }
        dist=copy;
        }
        return dist[dest]!=Integer.MAX_VALUE?dist[dest]:-1;
    }
}
