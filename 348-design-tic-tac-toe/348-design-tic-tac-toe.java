class TicTacToe {
    int[] row;
    int[] col;
    int dia;
    int anti_dia;
    int len;
    public TicTacToe(int n) {
        this.row=new int[n];
        this.col=new int[n];
        this.dia=0;
        this.anti_dia=0;
        this.len=n;
    }
    
    public int move(int row, int col, int player) {
        int toAdd=(player==1)? 1:-1;
        
        this.row[row]+=toAdd;
        this.col[col]+=toAdd;
        if(row==col) dia+=toAdd;
        if(col==(this.len-row-1)) anti_dia+=toAdd;
        if(Math.abs(this.row[row])==len || Math.abs(this.col[col])==len || Math.abs(dia)==len || Math.abs(anti_dia)==len) return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */