class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans=0, last=-1, n=seats.length;
        for(int i=0; i<n; i++){
            if(seats[i]==1){
                if(last<0) ans=i;
                else ans=Math.max(ans, (i-last)/2);
                
                last=i;
            }
        }
        return Math.max(ans, n-last-1);
    }
}