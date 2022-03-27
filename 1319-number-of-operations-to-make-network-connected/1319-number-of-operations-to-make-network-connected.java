class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m=connections.length;
        if(m <n-1) return -1;
        
        int blocks=n;
        int[] father=new int[n];
        for(int i=0; i<n; i++) father[i]=i;
        
        for(int[] c:connections){
            int f1=findFather(father, c[0]);
            int f2=findFather(father, c[1]);
            
            if(f1 !=f2){
                father[f1]=f2;
                blocks--;
            }
        }
        return blocks-1;
    }
    private int findFather(int[] father, int i){
        while(father[i] !=i){
            i=father[i];
        }
        return i;
    }
}