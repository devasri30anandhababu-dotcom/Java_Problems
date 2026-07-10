class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] res=new int[nums.length-k+1];
        Deque<Integer> dq=new LinkedList<>();
        int j=0;
        for(int index=0;index<nums.length;index++){
            while(!dq.isEmpty()&&dq.peekFirst()<index-k)
            dq.pollFirst();
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[index])
            dq.pollLast();
            dq.offer(index);
            if(index>=k-1)
            res[j++]=nums[dq.peekFirst()];
        }
        return res;
            }
}   
