class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n=nums.length;
        int[][] dp=new int[n][k+1];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=k; j++){
                dp[i][j]=Integer.MAX_VALUE/2;
            }
        }
        
        int max=0, sum=0;
        for(int i=0; i<n; i++){
            max=Math.max(max, nums[i]);
            sum+=nums[i];
            dp[i][0]=max*(i+1)-sum;
        }
        
        for(int i=1; i<n; i++){
            for(int j=1; j<=Math.min(i,k); j++){
                max=0;
                sum=0;
                for(int s=i; s>=1; s--){
                    max=Math.max(max, nums[s]);
                    sum+=nums[s];
                    dp[i][j]=Math.min(dp[i][j], dp[s-1][j-1]+max*(i-s+1)-sum);
                }
            }
        }
        
        int ans=Integer.MAX_VALUE/2;
        for(int j=0; j<=k; j++){
            ans=Math.min(ans, dp[n-1][j]);
        }
        return ans;
    }//dp: [[0,1073741823,1073741823],[10,0,1073741823],[15,5,0],[45,15,5],[55,25,15]]
}