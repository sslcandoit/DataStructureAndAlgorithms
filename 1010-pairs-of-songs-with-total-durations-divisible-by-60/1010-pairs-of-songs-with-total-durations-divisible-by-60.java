class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count=new int[60];
        int ans=0;
        for(int t:time){
            int rem=t%60;
            if(rem==0) ans+=count[0];
            else ans+=count[60-rem];
            count[rem]++;
        }
        return ans;
    }
}