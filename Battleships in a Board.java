class Solution{
    public int countBattleships(char[][] board) {
        int rSize = board.length, cSize = board[0].length;
        int count=0;
        for(int row=0;row<rSize;row++){
            for(int col=0;col<cSize;col++){
                if(board[row][col]!='X') continue;
                if(row>0&&board[row-1][col]=='X') continue;
                if(col>0&&board[row][col-1]=='X') continue;
                count++;
            }
        }
        return count;
    }
   
}
