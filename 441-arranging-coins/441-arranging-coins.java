class Solution {
    public int arrangeCoins(int n) {
  /*      
long l = 0, r = n, t = 2 * (long) n;
        while (l < r) {
            long m = (l + r + 1) / 2;
            if ((1 + m) * m <= t) l = m;
            else r = m - 1;
        }
        return (int) l;
        */
        long l=1, r=n;
        while(l<r){
            long m=l+(r-l)/2+1;
            long sum=(1+m)*m/2;
   
            if(sum<=n) l=m;
            else r=m-1;
        }
        return (int)l;    
    }
    /* brute force
    public int arrangeCoins(int n) {
        int row=1;
        while(true){
            n-=row;
            if(n<row+1) break;
            row++;
        }
        return row;
    }
    */
}

    