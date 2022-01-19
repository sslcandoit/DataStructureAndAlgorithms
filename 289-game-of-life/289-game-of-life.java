class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==0){
                    int lives=countLives(board, i, j, dirs);
                    if(lives==3) board[i][j]=9;
                }else if(board[i][j]==1){
                    int lives=countLives(board, i, j, dirs);
                    if(lives<2 || lives>3) board[i][j]=-1;
                }
            }
        }
        updateBoard(board, dirs);
    }
    private int countLives(int[][] board, int i, int j, int[][] dirs){
        int count=0;
        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && (board[x][y]==1 || board[x][y]==-1)) count++;
        }
        return count;
    }
    private void updateBoard(int[][] board, int[][] dirs){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==9) board[i][j]=1;
                else if(board[i][j]==-1) board[i][j]=0;
            }
        }
    }
}