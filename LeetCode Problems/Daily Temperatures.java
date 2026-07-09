class Solution {
    public int[] dailyTemperatures(int[] tempe) {
        int [] res=new int [tempe.length];
        Stack<Integer> pos=new Stack<>();
        for(int index=0;index<tempe.length;index++){
            while(!pos.isEmpty()&&tempe[pos.peek()] < tempe[index]){
                int popped=pos.pop();
                res[popped]=index-popped;
            }
            pos.push(index);
        }  
        return res; }

}
