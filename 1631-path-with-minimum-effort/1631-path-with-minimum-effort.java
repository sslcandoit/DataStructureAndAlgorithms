class Solution {
    private int[][] dirs={{0,1}, {0, -1}, {1,0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(heights[cur[1]][cur[2]]==-1) continue;
            if(cur[1]==m-1 && cur[2]==n-1) return cur[0];
            for(int[] d:dirs){
                int i=d[0]+cur[1], j=d[1]+cur[2];
                if(i>=0 && i<m && j>=0 && j<n && heights[i][j] !=-1){
                    int diff=Math.abs(heights[cur[1]][cur[2]]-heights[i][j]);
                    diff=Math.max(cur[0], diff);
                    pq.offer(new int[]{diff, i, j});
                }
            }
            heights[cur[1]][cur[2]]=-1;
        }
        return -1;
    }
    /*
    public int minimumEffortPath(int[][] heights) {
        int l=0, r=1000000, mid;
        while(l<r){
            mid=l+(r-l)/2;
            if(helper(heights, mid, 0, new HashSet<>())) r=mid;
            else l=mid+1;
        }
        return l;
    }
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
    */
}