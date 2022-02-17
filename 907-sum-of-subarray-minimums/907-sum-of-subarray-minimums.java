class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        long ans=0;
        long mod=(long)1e9+7;
        
        for(int i=0; i<=arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>(i==arr.length? 0:arr[i])){
                int mid=stack.pop();
                int left=(stack.isEmpty())? -1:stack.peek();
                int right=i;
                ans=(ans+(long)arr[mid]*(mid-left)*(right-mid))%mod;
            }
            stack.push(i);
        }
        return (int)ans;
    }
}