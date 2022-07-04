class Solution {
    public int minOperations(int[] nums, int x) {
        int m=nums.length;
        int target=Arrays.stream(nums).sum()-x;
        if(target==0) return m;
        
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, -1);
        int sum=0, ans=Integer.MIN_VALUE;
        
        for(int i=0; i<m; i++){
            sum+=nums[i];
            if(map.containsKey(sum-target)) ans=Math.max(ans, i-map.get(sum-target));
            map.put(sum, i);
        }
        return ans==Integer.MIN_VALUE? -1:m-ans;
    }
}