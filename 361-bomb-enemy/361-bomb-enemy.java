class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m=grid.length, n=grid[0].length, ans=0;
        
        int[] cols=new int[n];
        
        for(int i=0; i<m; i++){
            
            int eInRows=0;
            
            for(int j=0; j<n; j++){
                
                char c=grid[i][j];
                
                if(c=='W'){
                    eInRows=0;
                    cols[j]=0;
                }else if(c=='E'){
                    eInRows++;
                    cols[j]++;
                }else{
                    int total=eInRows+cols[j];
                    for(int ii=i+1; ii<m && grid[ii][j] !='W'; ii++){
                        if(grid[ii][j]=='E') total++;
                    } 
                    for(int jj=j+1; jj<n && grid[i][jj] !='W'; jj++){
                        if(grid[i][jj]=='E') total++;
                    } 
                    ans=Math.max(ans, total);
                }
            }
        }
        return ans;
    }
}
/*
W
E
W
O
E
*/
