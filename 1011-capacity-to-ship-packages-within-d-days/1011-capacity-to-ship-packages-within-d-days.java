class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=Arrays.stream(weights).sum();
        int l=sum/days;
        int r=sum;
        
        while(l<r){
            int m=l+(r-l)/2;
            if(isValid(weights, m, days)) r=m;
            else l=m+1;
        }
        return l;
    }
    private boolean isValid(int[] nums, int m, int days){
        int curTotal=0;
        int countDays=0;
        for(int n:nums){
            if(n>m) return false;
            else if(curTotal+n>m){
                countDays++;
                curTotal=n;
            }else curTotal+=n;
        }
        countDays++;
        if(countDays<=days) return true;
        return false;
    }
}