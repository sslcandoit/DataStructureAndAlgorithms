class SparseVector {
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        this.map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=0) map.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> small=(this.map.size()<vec.map.size())? this.map: vec.map;
        Map<Integer, Integer> large=(this.map.size()>=vec.map.size())? this.map: vec.map;
        int sum=0;
        for(Map.Entry<Integer, Integer> e: small.entrySet()){
            int index=e.getKey();
            if(large.containsKey(index)) sum+=e.getValue()*large.get(index);
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);