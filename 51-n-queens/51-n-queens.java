class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] b:board){
            for(int i=0; i<n; i++) b[i]='.';
        }
        helper(ans, board, 0);
        return ans;
    }
    private void helper(List<List<String>> ans, char[][] board, int curRow){
        if(curRow==board.length){
            ans.add(reWrite(board));
            return;
        }
        for(int col=0; col<board.length; col++){
            if(isValid(board, curRow, col)){
                board[curRow][col]='Q';
                helper(ans, board, curRow+1);
                board[curRow][col]='.';
            }
        }
    }
    private boolean isValid(char[][] board, int r, int c){
        for(int i=0; i<r; i++){
            if(board[i][c]=='Q') return false;
        }
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=r-1, j=c+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
    private List<String> reWrite(char[][] board){
        List<String> ans=new ArrayList<>();
        for(char[] b:board){
            StringBuilder sb=new StringBuilder();
            for(char c:b) sb.append(c);
            ans.add(sb.toString());
        }
        return ans;
    }
}