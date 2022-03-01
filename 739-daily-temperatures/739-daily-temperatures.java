class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty() || temperatures[i]<=temperatures[stack.peek()]) stack.push(i);
            else{
                while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                    ans[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}