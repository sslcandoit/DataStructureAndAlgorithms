class Solution {
    public int[] searchRange(int[] nums, int target) {
        int m=nums.length;
        int[] ans=new int[2];
        
        if(m==0 || (m==1 && nums[0] !=target)) return new int[]{-1,-1};
        else if(m==1 && nums[0]==target) return new int[]{0, 0};
        
        int l=0, r=m;
        ans[0]=findLeft(nums, l, r, target);
        ans[1]=findRight(nums, l, r, target);
        return ans;
    }
    private int findLeft(int[] nums, int l, int r, int target){
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]>=target) r=m;
            else l=m+1;
        }
        if(l>=nums.length) return -1;
        if(nums[l]==target) return l;
        return -1;
    }
    private int findRight(int[] nums, int l, int r, int target){
        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]>target) r=m;
            else l=m+1;
        }
        if(l==0) return -1;
        else if(nums[l-1]==target) return l-1;
        return -1;
    }
}