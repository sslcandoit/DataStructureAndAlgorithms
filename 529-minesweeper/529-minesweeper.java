class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        int m=board.length, n=board[0].length;
        int x=click[0], y=click[1];
        
        int mine=0;
        char c=board[x][y];
        if(c=='M' || c=='X'){
            board[x][y]='X';
            return board;
        }else if(c=='E'){
            for(int[] dir:dirs){
                int newX=x+dir[0];
                int newY=y+dir[1];
                if(newX>=0 && newY>=0 && newX<m && newY<n && board[newX][newY]=='M') mine++;
            }
            if(mine>0){
                board[x][y]=(char)(mine+'0');
                return board;
            }else{
                board[x][y]='B';
                for(int[] dir:dirs){
                    int newX=x+dir[0];
                    int newY=y+dir[1];
                    if(newX>=0 && newY>=0 && newX<m && newY<n) updateBoard(board, new int[]{newX, newY});
                }
            }
        }
        return board;
    }
}