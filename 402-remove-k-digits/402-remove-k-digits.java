class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k) return "0";
        
        Deque<Integer> deque=new ArrayDeque<>();
        int i=0; 
        while(i<n){
            while(k>0 && !deque.isEmpty() && deque.peekLast()>num.charAt(i)-'0'){
                deque.pollLast();
                k--;
            }
            deque.offerLast(num.charAt(i++)-'0');   
        }
        while(k>0){
            deque.pollLast();
            k--;
        } 
        while(!deque.isEmpty() && deque.peekFirst()==0) deque.pollFirst();
        
        String ans="";
        while(!deque.isEmpty()) ans+=deque.pollFirst();
        
        return ans.length()==0? "0":ans;
    }
}