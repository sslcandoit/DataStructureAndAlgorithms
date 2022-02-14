class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        
        long l=1;
        long r=(long)x+1;
        while(l<r){
            long m=l+(r-l)/2;
            if(m>x/m) r=m;
            else l=m+1;
        }
        return (int)l-1;
        /*
        int l=0;
        int r=x/2;
        while(l<r){
            int mid=l+(r-l)/2;
            if(mid*mid==x) return mid;
            else if(mid*mid<x) l=mid+1;
            else r=mid-1;
        }
        return r;
        */
    }
}