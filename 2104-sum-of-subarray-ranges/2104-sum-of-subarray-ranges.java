class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        long smallestSum=0, largestSum=0;
        
        for(int r=0; r<=n; r++){
            while(!stack.isEmpty() && nums[stack.peek()]> (r==n? Integer.MIN_VALUE:nums[r])){
                int mid=stack.pop();
                int l= stack.isEmpty()? -1:stack.peek();
                smallestSum += (long)nums[mid]*(r-mid)*(mid-l);
            }
            stack.push(r);
        }
        stack.clear();
        for(int r=0; r<=n; r++){
            while(!stack.isEmpty() && nums[stack.peek()]< (r==n? Integer.MAX_VALUE:nums[r])){
                int mid=stack.pop();
                int l=stack.isEmpty()? -1:stack.peek();
                largestSum+= (long)nums[mid]*(r-mid)*(mid-l);
            }
            stack.push(r);
        } 
        return largestSum-smallestSum;
    }
}