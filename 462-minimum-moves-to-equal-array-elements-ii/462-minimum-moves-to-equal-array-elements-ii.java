class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves=0;
        
        int l=0, r=nums.length-1;
        while(l<r){
            moves+=nums[r--]-nums[l++];
        }
        return moves;
    }
}//[1,2,9,10] [00168]