class DetectSquares {
    int[][] points;
    List<int[]> list;
    public DetectSquares() {
        this.points=new int[1001][1001];
        this.list=new ArrayList<>();
    }
    
    public void add(int[] point) {
        list.add(point);
        points[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int x=point[0], y=point[1], ans=0;
        for(int[] p3:list){
            int x3=p3[0], y3=p3[1];
            
            if(x==x3 || y==y3 || Math.abs(x-x3) !=Math.abs(y-y3)) continue;
            
            ans+=this.points[x][y3]*this.points[x3][y];
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */