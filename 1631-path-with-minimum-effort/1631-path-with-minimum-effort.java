class Solution {
    public int minimumEffortPath(int[][] heights) {
        int l=0, r=1000000, mid;
        while(l<r){
            mid=l+(r-l)/2;
            if(helper(heights, mid, 0, new HashSet<>())) r=mid;
            else l=mid+1;
        }
        return l;
    }
    private int[][] dirs={{0,1}, {0, -1}, {1,0}, {-1, 0}};
    private boolean helper(int[][] heights, int diff, int index, Set<Integer> visited){
        int m=heights.length, n=heights[0].length;
        int x=index/n, y=index%n;
        if(x==m-1 && y==n-1) return true;
        visited.add(index);
        
        for(int[] d:dirs){
            int i=d[0]+x, j=d[1]+y;
            int newIndex=i*n+j;
            if(i>=0 && i<m && j>=0 && j<n && !visited.contains(newIndex) 
               && Math.abs(heights[x][y]-heights[i][j])<=diff
               && helper(heights, diff, newIndex, visited)) return true;
        }
        //visited.remove(index);
        return false;
    }
}