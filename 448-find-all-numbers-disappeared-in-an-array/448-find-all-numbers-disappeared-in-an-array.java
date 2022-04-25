class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        for(int i=0; i<n; i++) nums[(nums[i]-1)%n]+=n;
        
        List<Integer> ans=new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i]<=n) ans.add(i+1);
        }
        return ans;
    }
    /*
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //index sorting
        for(int i=0; i<nums.length; i++){
            while(nums[i] !=i+1 && nums[i] !=nums[nums[i]-1]){
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=i+1) ans.add(i+1);
        }
        return ans;
    }
    */
}