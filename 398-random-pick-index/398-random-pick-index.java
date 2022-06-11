class Solution {
    Map<Integer, List<Integer>> map;
    Random rd;
    
    public Solution(int[] nums) {
        this.map=new HashMap<>();
        this.rd=new Random();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list=map.get(target);
        return list.get(this.rd.nextInt(list.size()));
    }
    /*
    int[] nums;
    Random rd;
    public Solution(int[] nums) {
        this.nums=nums;
        this.rd=new Random();
    }
    
    public int pick(int target) {
        int ans=0, count=0;
        for(int i=0; i<this.nums.length; i++){
            if(this.nums[i] !=target) continue;
            if(this.rd.nextInt(++count)==0) ans=i;
        }
        return ans;
    }
    /*
    2 : It's probability of selection is 1 * (1/2) * (2/3) = 1/3
    3 : It's probability of selection is (1/2) * (2/3) = 1/3
    4 : It's probability of selection is just 1/3

So they are each randomly selected.
    */
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */