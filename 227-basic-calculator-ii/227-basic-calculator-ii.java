class Solution {
    public int calculate(String s) {
        int n=s.length();
        Stack<Integer> stack=new Stack<>();
        int i=0;
        int num=0;
        char sign='+';
        while(i<n){
            while(i<n && Character.isDigit(s.charAt(i))) num=num*10+(s.charAt(i++)-'0');
            if(i>=n-1 || i<n && !Character.isDigit(s.charAt(i)) && s.charAt(i) !=' '){
                if(sign=='+') stack.push(num);
                else if(sign=='-') stack.push(-num);
                else if(sign=='*') stack.push(num*stack.pop());
                else if(sign=='/') stack.push(stack.pop()/num);
                if(i<n) sign=s.charAt(i);
                num=0;
            }
            i++;
        }
        int ans=0;
        while(!stack.isEmpty()) ans+=stack.pop();
        return ans;
    }
}