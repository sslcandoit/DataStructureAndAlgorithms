class Solution {
    public String simplifyPath(String path) {
        String[] str=path.split("/");
        Stack<String> stack=new Stack<>();
        
        for(String s:str){
            if(s.equals(".")||s.isEmpty()) continue;
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else stack.push(s);
        }
        String ans="";
        while(!stack.isEmpty()) ans="/"+stack.pop()+ans;
        return ans.length()==0? "/":ans;  
    }
}