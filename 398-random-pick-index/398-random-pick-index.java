class Solution {
     private HashMap<Integer, List<Integer>> indices;
    private Random rand;
    
    public Solution(int[] nums) {
        this.rand = new Random();
        this.indices = new HashMap<Integer, List<Integer>>();
        int l = nums.length;
        for (int i = 0; i < l; ++i) {
            if (!this.indices.containsKey(nums[i])) {
                this.indices.put(nums[i], new ArrayList<>());
            }
            this.indices.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int l = indices.get(target).size();
        // pick an index at random
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
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