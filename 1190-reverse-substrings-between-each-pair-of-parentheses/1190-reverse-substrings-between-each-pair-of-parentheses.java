class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> dq=new ArrayDeque<>();
        dq.offerFirst(new StringBuilder());
        
        int len=s.length();
        for(int i=0; i<len; i++){
            char c=s.charAt(i);
            
            if(c=='(') dq.offerFirst(new StringBuilder());
            else if(c==')'){
                StringBuilder first=dq.pollFirst();
                dq.peekFirst().append(first.reverse());
            }else{
                dq.peekFirst().append(c);
            }
        }
        return dq.peekFirst().toString();
    }//"a(bcdefghijkl(mno)p)q"
}

