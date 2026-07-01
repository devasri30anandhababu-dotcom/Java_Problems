import java.util.Arrays;
class Solution {
    public void sortColors(int[] arr) {
        int start =0,end=arr.length,index=0;
        while(index<=end){
            if(arr[index]==2){
                int third=arr[end];
                arr[end]=arr[index];
                arr[index]=third;
                end--;
            }
            else if(arr[index]==0){
                int first=arr[start];
                arr[start]=arr[index];
                arr[index]=first;
                start++;index++;

            }
            else index++;
        }
    }
    public static void main(String[]args){

    }
}
