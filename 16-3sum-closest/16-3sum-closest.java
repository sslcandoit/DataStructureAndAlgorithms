class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0; i<len-2; i++){
            int l=i+1, r=len-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(Math.abs(target-sum)<Math.abs(diff)) diff=target-sum;
                
                if(sum<target) l++;
                else r--;
            }
        }
        return target-diff;
    }
}