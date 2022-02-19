class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0; i<asteroids.length; i++){
            int size=asteroids[i];
            if(size>0 || stack.isEmpty() || stack.peek()<0) stack.push(size);
            else if(Math.abs(size)==Math.abs(stack.peek())) stack.pop();
            else if(Math.abs(size)>Math.abs(stack.peek())){
                stack.pop();
                i--;
            }
        }
        int[] ans=new int[stack.size()];
        int i=stack.size()-1;
        while(!stack.isEmpty()) ans[i--]=stack.pop();
        return ans;
    }
}