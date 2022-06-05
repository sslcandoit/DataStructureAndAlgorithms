class Solution {
    private int[] father;
    public int regionsBySlashes(String[] grid) {
        int m=grid.length;
        this.father=new int[(m+1)*(m+1)];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=m; j++){
                int index=i*(m+1)+j;
                father[index]=index;
                if(i==0 || i==m || j==0 || j==m) this.father[index]=0;
            }
        }
        int ans=1, a, b;
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                char c=grid[i].charAt(j);
                if(c==' ') continue;
                else if(c=='/'){
                    a=i*(m+1)+(j+1);
                    b=(i+1)*(m+1)+j;
                }else{
                    a=i*(m+1)+j;
                    b=(i+1)*(m+1)+(j+1);
                }
                if(findFather(a)==findFather(b)) ans++;
                else union(a, b);
            }
        }
        return ans;
    }
    private int findFather(int x){
        if(this.father[x] !=x) this.father[x]=findFather(this.father[x]);
        return this.father[x];
    }
    private void union(int a, int b){
        int x=this.father[a];
        int y=this.father[b];
        if(x<y) this.father[y]=x;
        else this.father[x]=y;
    }
}