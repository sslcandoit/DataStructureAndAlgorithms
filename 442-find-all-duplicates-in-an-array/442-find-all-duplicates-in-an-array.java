class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //Method 3: encode
        List<Integer> ans= new ArrayList<>();
        for(int num:nums){
            int n=Math.abs(num);
            if(nums[n-1]<0) ans.add(n);
            else nums[n-1]*=-1;
        }
        return ans;
        //Method 2: sort
        //Method 1: HashSet
    }
}