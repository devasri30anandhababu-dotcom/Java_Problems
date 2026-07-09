class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxA=0,temp=0;
        Stack<Integer> pos=new Stack<>();
        for(int index=0;index<=heights.length;index++){
            int cValue=(index==heights.length)?0:heights[index];
            while(!pos.isEmpty()&&cValue<heights[pos.peek()]){
                int len=heights[pos.pop()];
                int brd=pos.isEmpty()?index:index-pos.peek()-1;
                temp=len*brd;
                maxA=Math.max(maxA,temp);
            }
            pos.push(index);
        }
        return maxA;
            }
}
