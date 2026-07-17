import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    boolean[][] visited;
    int[][] dirt = {{1,0},{-1,0},{0,1},{0,-1}};
    int[][] grid;
    int og;
    List<int[]> toBeColored = new ArrayList<>();
    public void dfs(int row, int col){
        visited[row][col]=true;
        int sCount=0;
        for(int[] each:dirt){
            int cr=row+each[0], cc=col+each[1];
            if(cr>=0&&cc>=0&&cr<grid.length&&cc<grid[0].length)
                if(grid[cr][cc]==og){
                    sCount++;
                    if(!visited[cr][cc]) dfs(cr,cc);
                }
        }
        if(sCount<4) toBeColored.add(new int[]{row,col});
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color){
        this.grid = grid;og = grid[row][col];
        visited = new boolean[grid.length][grid[0].length];
        dfs(row,col);
        for(int[] choosen:toBeColored) 
            grid[choosen[0]][choosen[1]] = color;
        return grid;
    }
   
}
