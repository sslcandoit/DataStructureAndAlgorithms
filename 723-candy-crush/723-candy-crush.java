class Solution {
    public int[][] candyCrush(int[][] board) {
        int m=board.length, n=board[0].length;
        boolean isStable=true;
        
        for(int i=0; i<m; i++){
            for(int j=0; j+2<n; j++){
                int val=Math.abs(board[i][j]);
                if(val !=0 && val==Math.abs(board[i][j+1]) && val==Math.abs(board[i][j+2])){
                    board[i][j]=board[i][j+1]=board[i][j+2]=-val;
                    isStable=false;
                }
            }
        }
        for(int j=0; j<n; j++){
            for(int i=0; i+2<m; i++){
                int val=Math.abs(board[i][j]);
                if(val !=0 && val==Math.abs(board[i+1][j]) && val==Math.abs(board[i+2][j])){
                    board[i][j]=board[i+1][j]=board[i+2][j]=-val;
                    isStable=false;
                }
            }
        }
        for(int j=0; j<n; j++){
            int write=m-1;
            for(int i=m-1; i>=0; i--){
                if(board[i][j]>0) board[write--][j]=board[i][j];
            }
            while(write>=0) board[write--][j]=0;
        }
        return isStable? board:candyCrush(board);
    }
}