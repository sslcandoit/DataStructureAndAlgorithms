class Solution {
    private static Map<String, BiFunction<Integer, Integer, Integer>> map=new HashMap<>();
    static{
        map.put("+", (a,b)->a+b);
        map.put("-", (a,b)->a-b);
        map.put("*", (a,b)->a*b);
        map.put("/", (a,b)->a/b);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(String s:tokens){
            if(map.containsKey(s)){
                int b=stack.pop();
                int a=stack.pop();
                BiFunction<Integer, Integer, Integer> bf=map.get(s);
                int ans=bf.apply(a,b);
                stack.push(ans);
            }else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
        /*
        Stack<Integer> stack=new Stack<>();
        
        for(String s:tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                if(s.equals("+")) stack.push(stack.pop()+stack.pop());
                else if(s.equals("-")){
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push(a-b);
                }else if(s.equals("*")) stack.push(stack.pop()*stack.pop());
                else{
                    int b=stack.pop();
                    int a=stack.pop();
                    stack.push(a/b);
                }
            }else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
        */
    }
}