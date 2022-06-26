class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans=new int[rows*cols][2];
        
        int rS=rStart, rE=rStart, cS=cStart, cE=cStart, index=0;
        while(rS>=0 || rE<rows || cS>=0 || cE<cols){
            if(rS>=0){//go right
                for(int i=Math.max(cS, 0); i<=Math.min(cE, cols-1); i++) ans[index++]=new int[]{rS, i};
            }
            cE++;
            
            if(cE<cols){//go down
                for(int i=Math.max(rS, 0); i<=Math.min(rE, rows-1); i++) ans[index++]=new int[]{i, cE};
            }
            rE++;
            
            if(rE<rows){//go left
                for(int i=Math.min(cE, cols-1); i>=Math.max(cS, 0); i--) ans[index++]=new int[]{rE, i};
            }
            cS--;
            
            if(cS>=0){//go up
                for(int i=Math.min(rE, rows-1); i>=Math.max(rS, 0); i--) ans[index++]=new int[]{i, cS};
            }
            rS--;
        }
        return ans;
    }
}
