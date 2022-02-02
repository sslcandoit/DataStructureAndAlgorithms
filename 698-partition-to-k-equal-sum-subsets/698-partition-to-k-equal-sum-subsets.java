class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=Arrays.stream(nums).sum();
        if(sum%k !=0) return false;
        
        Arrays.sort(nums);
        sum=sum/k;
        int n=nums.length;
        if(nums[n-1]>sum) return false;
        
        int i=n-1;
        while(i>=0 && nums[i]==sum){
            i--;
            k--;
        }
        if(k==0) return true;
        return canPartition(new int[k], sum, nums, i);
    }
    private boolean canPartition(int[] add, int target, int[] nums, int index){
        if(index<0) return true;
        
        int cur=nums[index];
        for(int i=0; i<add.length; i++){
            if(add[i]+cur<=target){
                add[i]+=cur;
                if(canPartition(add, target, nums, index-1)) return true;
                add[i]-=cur;
            }
        }
        return false;
    }
}