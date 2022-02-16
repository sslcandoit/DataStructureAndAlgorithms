class Solution {
    public int findDuplicate(int[] nums) {
        //example: [4,6,4,2,1,4,3,5] count(1,2,3,4,5,6,7) = (1,2,3,6,7,8,8). ans=4
        int l=1;
        int r=nums.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            int count=0;
            for(int num:nums){
                if(num<=m) count++;
            }
            if(count>m) r=m;
            else l=m+1;
        }
        return l;
        
        /*
        int slow=nums[nums[0]];
        int fast=nums[nums[nums[0]]];
        while(slow !=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=nums[0];
        while(slow !=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
        */
    }
}