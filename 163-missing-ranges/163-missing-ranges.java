class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans=new ArrayList<>();
        int len=nums.length;
        
        if(len==0){
            if(lower==upper) ans.add(lower+"");
            else ans.add(lower+"->"+upper);
            return ans;
        } 
        
        for(int i=0; i<=len; i++){
            
            int low= (i==0? lower : nums[i-1]+1);
            int upp= (i==len? upper: nums[i]-1);
            
            if(upp<low) continue;
            else if(upp==low) ans.add(upp+"");
            else ans.add(low+"->"+upp);
        }
       
        return ans;
    }
}