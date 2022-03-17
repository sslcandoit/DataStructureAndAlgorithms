class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] c=s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(c[i]=='(') stack.push(i);
            else if(c[i]==')'){
                if(!stack.isEmpty()) stack.pop();
                else c[i]='*';
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=c.length-1; i>=0; i--){
            if(c[i]=='*') continue;
            if(!stack.isEmpty() && i==stack.peek()) stack.pop();
            else sb.append(c[i]);
        }
        return sb.reverse().toString();
    }
}