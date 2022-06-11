class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        
        int rowS=0, rowE=n-1, colS=0, colE=n-1;
        int num=1;
        while(rowS<=rowE && colS<=colE){
            
            for(int j=colS; j<=colE; j++) ans[rowS][j]=num++;
            rowS++;
            
            for(int i=rowS; i<=rowE; i++) ans[i][colE]=num++;
            colE--;
            
            for(int j=colE; j>=colS; j--) ans[rowE][j]=num++;
            rowE--;
            
            for(int i=rowE; i>=rowS; i--) ans[i][colS]=num++;
            colS++;
        }
        return ans;
    }
}