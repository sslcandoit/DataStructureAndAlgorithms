class Solution {
    /*
    public int scoreOfParentheses(String s) {
        int ans=0;
        int left=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') left++;
            else left--;
            
            if(s.charAt(i)==')' && s.charAt(i-1)=='(') ans+=(1<<left);
        }
        return ans;
    }
    */
    public int scoreOfParentheses(String s) {
        int score=0;
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(score);
                score=0;
            }else score=stack.pop()+Math.max(score*2, 1);
        }
        return score;   
    }
}