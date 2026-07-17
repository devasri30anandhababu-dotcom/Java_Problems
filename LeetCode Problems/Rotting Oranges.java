import java.util.LinkedList;
import java.util.Queue;
class Solution{
   public int orangesRotting(int[][] grid) {
        int rSize=grid.length, cSize=grid[0].length;
        int fresh=0,mint=0, row=0,col=0, size = 0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> que = new LinkedList<>();
        for(row=0;row<rSize;row++){
            for(col=0;col<cSize;col++){
                if(grid[row][col]==2) 
                    que.offer(new int[]{row,col});
                if(grid[row][col]==1) fresh++;
            }
        }
        while(!que.isEmpty()&&fresh>0){
            size = que.size();
            for(int index=0;index<size;index++){
                int[] cur = que.poll();
                for(int[] each:dir){
                    row=cur[0]+each[0];col=cur[1]+each[1];
                    if(row<0||col<0||row>=rSize||col>=cSize||
                        grid[row][col]!=1)
                        continue;
                    grid[row][col]=2;fresh--;
                    que.offer(new int[]{row,col});
                }
            }
            mint++;
        }
        return fresh!=0?-1:mint;
   }
  
}
