class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=0, countEven=0;
        for(int l=0, r=0; r<nums.length; r++){
            if(nums[r] %2==1){
                k--;
                countEven=0;
            } 
            while(k==0){
                if(nums[l++] %2==1) k++;
                countEven++;
            }
            ans+=countEven;
        }
        return ans;
        /*
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int res = 0, i = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            k -= nums[j] % 2;
            while (k < 0)
                k += nums[i++] % 2;
            res += j - i + 1;
        }
        return res;
        */
    }
}