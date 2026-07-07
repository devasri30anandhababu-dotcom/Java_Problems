class Solution {
    public int lengthOfLIS(int[] nums) {
     int size=nums.length,mlen=1;
     int[] dp=new int [size];
     Arrays.fill(dp,1);
     for(int index=1;index<size;index++){
        for(int j=0;j<index;j++)
            if(nums[index]>nums[j])
            dp[index]=Math.max(dp[index],dp[j]+1);
            mlen=Math.max(mlen,dp[index]);
     }
     return mlen;
    }
}
