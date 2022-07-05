class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int m=nums.length, sum=0, ans=0;
        for(int l=0, r=0; r<m; r++){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
            set.add(nums[r]);
            sum+=nums[r]; 
            ans=Math.max(ans, sum);
        }
        return ans;
    }
}