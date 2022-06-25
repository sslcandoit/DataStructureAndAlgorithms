class Solution {
    int[] ans=new int[12];
    int maxPoints=0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        helper(aliceArrows, new int[12], numArrows, 0, 11);
        return this.ans;
    }
    private void helper(int[] a, int[] b, int remainArrows, int bobPoints, int i){
        if(i==0 || remainArrows==0){
            if(remainArrows>0) b[0]+=remainArrows;
            if(bobPoints>this.maxPoints){
                maxPoints=bobPoints;
                this.ans=b.clone();
            }
            b[0]-=remainArrows;
            return;
        }
        if(remainArrows>a[i]){
            b[i]=a[i]+1;
            helper(a, b, remainArrows-b[i], bobPoints+i, i-1);
        }
        b[i]=0;
        helper(a, b, remainArrows, bobPoints, i-1);
    }
}