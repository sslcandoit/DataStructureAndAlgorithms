class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] row=new int[3], col=new int[3];
        int dia=0, anti_dia=0;
        
        int countX=0, countO=0, xWin=0, oWin=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                char c=board[i].charAt(j);
                if(c=='X'){
                    countX++;
                    row[i]++;
                    col[j]++;
                    if(i==j) dia++;
                    if(j==3-i-1) anti_dia++;
                }else if(c=='O'){
                    countO++;
                    row[i]--;
                    col[j]--;
                    if(i==j) dia--;
                    if(j==3-i-1) anti_dia--;
                } 
                if(row[i]==3 || col[j]==3 || dia==3 || anti_dia==3) xWin++;
                if(row[i]==-3 || col[j]==-3 || dia==-3 || anti_dia==-3) oWin++;
            }
        }
        if((xWin>0 && countO>=countX) || (oWin>0 && countX>countO)) return false;
        if((countX-countO>=2)||(countO>countX)) return false;
        return true;
    }
}
/*
"XXX",
"   ",
"OOO"

"XXX",
"XOO",
"OO "

"OXX",
"XOX",
"OXO"

"X X",
"  O",
" XX"
*/