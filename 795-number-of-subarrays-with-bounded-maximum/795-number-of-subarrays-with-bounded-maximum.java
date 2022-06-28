class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        Stack<Integer> stack=new Stack<>();//递减
        int n=nums.length;
        int ans=0;
        for(int r=0; r<=n; r++){
            while(!stack.isEmpty() && nums[stack.peek()]< (r==n? Integer.MAX_VALUE:nums[r])){
                int mid=stack.pop();
                if(nums[mid]>=left && nums[mid]<=right){
                    int l=stack.isEmpty()? -1:stack.peek();
                    ans+=(r-mid)*(mid-l);
                }
            }
            stack.push(r);
        }
        return ans;
    }
}