class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s==null || s.length()==0) return "";
        Stack<Integer> stack=new Stack<>();
        
        char[] ch=s.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(ch[i]=='(') stack.push(i);
            else if(ch[i]==')'){
                if(!stack.isEmpty()) stack.pop();
                else ch[i]='?';
            }  
        }
        StringBuilder sb=new StringBuilder();
        for(int i=ch.length-1; i>=0; i--){
            
            if(!stack.isEmpty() && stack.peek()==i){
                stack.pop();
                continue;
            }else if(ch[i]=='?') continue;
        sb.append(ch[i]);
        }
    return sb.reverse().toString();
    }
}