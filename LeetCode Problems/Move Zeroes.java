class Solution {
    public void moveZeroes(int[] nums) {
        int inex=0,correct=0,size=current.length;
        while(index<size){
            if(current[index]!=0){
                current[correct]=current[index];
                correc++;
            }
            index++;
        }
        Arrays.fill(current, correct,size,val:0);

    }
    
    public static void main (String[]args){
        int [] nums = new int [nums];
        Solution obj=new Solution();
        obj.MovesZeros(nums);

    }
    }
