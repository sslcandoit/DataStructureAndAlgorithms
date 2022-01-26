class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        
        for(int j=0; j<n; j++){
            if(board[0][j]=='O') dfs(board, 0, j);
            if(board[m-1][j]=='O') dfs(board, m-1, j);
        }
        for(int i=0; i<m; i++){
            if(board[i][0]=='O') dfs(board, i, 0);
            if(board[i][n-1]=='O') dfs(board, i, n-1);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='A') board[i][j]='O';
            }
        }
    }
    private void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] !='O') return;
        
        board[i][j]='A';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}