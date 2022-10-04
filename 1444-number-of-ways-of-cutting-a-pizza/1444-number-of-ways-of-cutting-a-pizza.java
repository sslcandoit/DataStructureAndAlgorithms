class Solution {
    public int ways(String[] pizza, int k) {
        int m=pizza.length, n=pizza[0].length();
        
        int[][] sumFromHere=new int[m+1][n+1];//统计从当前点开始之后一共有多少个苹果
        
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                char c=pizza[i].charAt(j);
                sumFromHere[i][j]=sumFromHere[i][j+1]+sumFromHere[i+1][j]-sumFromHere[i+1][j+1]+(c=='A'? 1:0);
            }
        }
        
        Integer[][][] dp=new Integer[k][m][n];
        return helper(dp, sumFromHere, m, n, k-1, 0, 0);
    }
    
    private int helper(Integer[][][] dp, int[][] sumFromHere, int m, int n, int k, int r, int c){
        if(sumFromHere[r][c]==0) return 0;//说明剩下这部分没有苹果，所以无效切法
        if(k==0) return 1;//说明已经找到一种有效切法
        if(dp[k][r][c] !=null) return dp[k][r][c];
        
        int ans=0;
        
        for(int i=r+1; i<m; i++){//cut horizontally
            if(sumFromHere[r][c]-sumFromHere[i][c]>0){
                ans= (ans+ helper(dp, sumFromHere, m, n, k-1, i, c)) % 1000000007;
            }
        }
        for(int j=c+1; j<n; j++){//cut vertically
            if(sumFromHere[r][c]-sumFromHere[r][j]>0){
                ans= (ans+ helper(dp, sumFromHere, m, n, k-1, r, j)) % 1000000007;
            }
        }
        
        return dp[k][r][c]=ans;
    }
}