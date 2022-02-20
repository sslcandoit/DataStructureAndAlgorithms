class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int num:nums) ans=ans^num;
        return ans;
    }
}