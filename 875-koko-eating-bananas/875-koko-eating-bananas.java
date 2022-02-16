class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=(int)1e9;
        while(l<r){
            int m=l+(r-l)/2;
            
            int hours=0;
            for(int p:piles){
                hours+=(p+m-1)/m;
            }
            
            if(hours>h) l=m+1;
            else r=m;
        }
        return l;
    }
}