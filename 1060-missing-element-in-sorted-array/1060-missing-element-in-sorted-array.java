class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + (right - left) / 2) + 1;
            int missing = nums[mid] - nums[left] - (mid - left);
            
            if (missing < k) {
                k -= missing;
                left = mid;
            } else right = mid - 1;
        }
        return nums[left] + k;
        
        /*
        int n=nums.length, l=0, r=n-1;
        int missed=nums[r]-nums[l]+1-n;
        if(missed<k) return nums[r]+(k-missed);
        
        while(l<r-1){
            int m=l+(r-l)/2;
            missed=nums[m]-nums[l]-(m-l);
            
            if(missed>=k) r=m;
            else{
                k-=missed;
                l=m;
            }
        }
        return nums[l]+k;
        */
    }
}