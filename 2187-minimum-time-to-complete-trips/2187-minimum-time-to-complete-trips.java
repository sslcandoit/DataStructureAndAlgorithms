class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min=1, max=Long.MAX_VALUE/time.length;
        
        while(min<max){
            long mid=min+(max-min)/2;
            
            long trips=0;
            for(int t:time){
                trips+=mid/t;
            }
            
            if(trips<totalTrips) min=mid+1;
            else max=mid;
        }
        return min;
    }
}