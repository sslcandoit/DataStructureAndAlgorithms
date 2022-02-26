class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m=isConnected.length;
        boolean[] visited=new boolean[m];
        int ans=0;
        for(int i=0; i<m; i++){
            if(!visited[i]){
                ans++;
                helper(isConnected, visited, i);
            } 
        }
        return ans;
    }
    private void helper(int[][] isConnected, boolean[] visited, int i){
        int m=isConnected.length;
        visited[i]=true;
        for(int j=0; j<m; j++){
            if(isConnected[i][j]==1 && !visited[j]) helper(isConnected, visited, j);
        }
    }
}