class Solution {
    Set<Integer> col=new HashSet<>();
    Set<Integer> dia=new HashSet<>();
    Set<Integer> antiDia=new HashSet<>();
    
    public int totalNQueens(int n) {
        return helper(n, 0, 0);
    }
    private int helper(int n, int row, int count){
        for(int c=0; c<n; c++){
            if(this.col.contains(c)) continue;
            
            int d=row+c;
            if(this.dia.contains(d)) continue;
            
            int antiD=row-c;
            if(this.antiDia.contains(antiD)) continue;
            
            if(row== n-1) count++;
            else{
                this.col.add(c);
                this.dia.add(d);
                this.antiDia.add(antiD);
                count=helper(n, row+1, count);
                
                //backtrack
                this.col.remove(c);
                this.dia.remove(d);
                this.antiDia.remove(antiD);
            }
        }
        return count;
    }
}