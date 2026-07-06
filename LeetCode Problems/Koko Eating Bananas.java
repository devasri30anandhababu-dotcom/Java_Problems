import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1,end=Arrays.stream(piles).max().orElse(0);
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(canEat(piles,h,mid)) end= mid-1;
            else start=mid+1;
        }
        return start;
    }
    public static boolean canEat(int []piles,int h,int mid){
    int curH=0;
    for(int each:piles) curH +=(each+mid-1)/mid;
    return curH<=h;
    }
}
