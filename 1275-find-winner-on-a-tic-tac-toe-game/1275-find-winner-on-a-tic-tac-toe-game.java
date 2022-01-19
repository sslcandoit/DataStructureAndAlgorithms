class Solution {
    public String tictactoe(int[][] moves) {
        int len=moves.length;
        if(len<5) return "Pending";
        
        int i=len-1;
        int row=0, col=0, dia=0, anti_dia=0;
        while(i>=0){
            if(moves[i][0]==moves[i][1]) dia++;
            if(moves[i][0]+moves[i][1]==2) anti_dia++;
            if(moves[i][0]==moves[len-1][0]) row++;
            if(moves[i][1]==moves[len-1][1]) col++;
            
            if(dia==3 || anti_dia==3 || row==3 || col==3) return len%2==0? "B":"A";
            i-=2;
        }
        return len==9? "Draw":"Pending";
    }
}