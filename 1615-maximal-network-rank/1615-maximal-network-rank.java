class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connect=new boolean[n][n];
        int[] road=new int[n];
        
        for(int[] r:roads){
            road[r[0]]++;
            road[r[1]]++;
            connect[r[0]][r[1]]=true;
            connect[r[1]][r[0]]=true;
        }
        int ans=0;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                ans=Math.max(ans, road[i]+road[j]-(connect[i][j]? 1:0));
            }
        }
        return ans;
    }
}