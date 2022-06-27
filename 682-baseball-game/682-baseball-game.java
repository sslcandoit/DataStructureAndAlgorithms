class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        for(String s:ops){
            if(s.equals("C")) stack.pop();
            else if(s.equals("D")) stack.push(2*stack.peek());
            else if(s.equals("+")){
                int after=stack.pop(), before=stack.pop();
                stack.push(before);
                stack.push(after);
                stack.push(after+before);
            }else stack.push(Integer.parseInt(s));
        }
        int sum=0;
        while(!stack.isEmpty()) sum+=stack.pop();
        return sum;
    }
}