class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        
        for(String s:strs){
            int one=0, zero=0;
            for(char c: s.toCharArray()) if(c=='0') zero++;
            
            one=s.length()-zero;
            
            for(int i=m; i>=zero; i--){
                for(int j=n; j>=one; j--){
                    dp[i][j]=Math.max(dp[i][j], dp[i-zero][j-one]+1);
                }
            }
        }
        return dp[m][n];
    }
    //    ["10","0001","111001","1","0"], m = 5, n = 3
    
    /*dp:     
         0个0   [0,0,0,0]  [0,0,0,0]  [0,0,0,0]  [0,1,1,1]  [0,1,1,1]
         1个0   [0,1,1,1]  [0,1,1,1]  [0,1,1,1]  [0,1,2,2]  [1,2,2,2]
         2个0   [0,1,1,1]  [0,1,1,1]  [0,1,1,1]  [0,1,2,2]  [1,2,3,3]
         3个0   [0,1,1,1]  [0,1,1,1]  [0,1,1,1]  [0,1,2,2]  [1,2,3,3]
         4个0   [0,1,1,1]  [0,1,2,2]  [0,1,2,2]  [0,1,2,3]  [1,2,3,3]
         5个0   [0,1,1,1]  [0,1,2,2]  [0,1,2,2]  [0,1,2,3]  [1,2,3,4]
    */
}