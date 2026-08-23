class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],1);
        }
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(mp.get(nums[i]) == 1){
                int length = 1;
                int k = nums[i]+1;
                while(mp.containsKey(k)){
                    int a = mp.get(k); 
                    mp.put(k,0);
                    length += a;
                    k+= a;  
                }
                ans = Math.max(ans,length);
                mp.put(nums[i],length);
            }
        }
        return ans;
    }
}
