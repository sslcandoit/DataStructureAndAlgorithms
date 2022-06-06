class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] pre=new double[1];
        pre[0]=poured;
        
        for(int r=0; r<query_row; r++){
            double[] cur=new double[pre.length+1];
            for(int j=0; j<pre.length; j++){
                if(pre[j]<=1) continue;
                
                double extra=(pre[j]-1)/2;
                cur[j]+=extra;
                cur[j+1]+=extra;
            }
            pre=cur;
        }
        return Math.min(1, pre[query_glass]);
    }
}