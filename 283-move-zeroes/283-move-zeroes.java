class Solution {
    public void moveZeroes(int[] nums) {
        int count=0, i, j;
        for(i=0, j=0; j<nums.length; j++){
            if(nums[j]==0) count++;
            else nums[i++]=nums[j];
        }
        while(count-- >0) nums[i++]=0;
    }
        /*
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
    /*
    [1]
    [0]
    [0,1]
    [1,0]
    */
}