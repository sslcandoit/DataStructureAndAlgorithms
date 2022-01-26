class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set=new HashSet<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    StringBuilder sb=new StringBuilder();
                    dfs(grid, sb, i, j, "(");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, StringBuilder sb, int i, int j, String dir){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        
        sb.append(dir);
        grid[i][j]=0;
        dfs(grid, sb, i+1, j, "D");
        dfs(grid, sb, i-1, j, "U");
        dfs(grid, sb, i, j+1, "R");
        dfs(grid, sb, i, j-1, "L");
        sb.append(")");
    }
}