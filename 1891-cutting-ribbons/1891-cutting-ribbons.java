class Solution {
    public int maxLength(int[] ribbons, int k) {
        int n=ribbons.length;
        
        int l=1, r=100001;
        while(l<r){
            int mid=l+(r-l)/2;
            
            int sum=0;
            for(int i=0; i<n; i++){
                sum+=ribbons[i]/mid;
            }
            if(sum>=k) l=mid+1;
            else r=mid;
        }
        return l-1;
    }
}