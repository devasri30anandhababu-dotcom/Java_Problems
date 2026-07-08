class Solution  {
    public int rob(int[]nums){
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int prev2=nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        int current=0;
        for(int index=2;index<nums.length;index++){
            current = Math.max(prev1, (nums[index]+prev2));
            prev2=prev1;prev1=current;
        }
        return prev1;
    }
    
}
