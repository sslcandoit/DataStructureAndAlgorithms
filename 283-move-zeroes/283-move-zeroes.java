class Solution {
    public void moveZeroes(int[] nums) {
        int len=nums.length;
        int l=0, r=0;
        while(r<len){
            while(l<len && nums[l] !=0) l++;
            if(l>=len-1) break;
            r=l+1;//[1,0,0]
            while(r<len && nums[r]==0) r++;
            if(r>=len) break;
            nums[l++]=nums[r];
            nums[r]=0;
        }
    }
}