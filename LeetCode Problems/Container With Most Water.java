import java.util.*;
class Solution {
    public int maxArea(int[] arr) {
        int left=0;
        int right=arr.length-1;
        int mwater=0;
        while(left<right){
            int width = right-left;
            int height=Math.min(arr[left],arr[right]);
            mwater=Math.max(mwater,width*height);
            if(arr[left]<arr[right]) left++;
            else right--;
        }
        return mwater;
    }
}
