class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        
        for(int i=1, offset=1; i<=n; i++){
            if(offset*2==i) offset=i;
            ans[i]=ans[i-offset]+1;
            //ans[i] = ans[i >> 1] + (i & 1);
            //ans[i]=Integer.bitCount(i);
        }
        return ans;
    }
}