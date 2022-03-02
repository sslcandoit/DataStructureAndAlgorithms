class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        int[] index=new int[26];
        for(int i=0; i<n; i++) index[s.charAt(i)-'a']=i;
        
        boolean[] onStack=new boolean[26];
        Deque<Character> deque=new ArrayDeque<>();
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(onStack[c-'a']) continue;
            while(!deque.isEmpty() && deque.peekLast()>c && index[deque.peekLast()-'a']>i){
                onStack[deque.pollLast()-'a']=false;
            }
            if(!onStack[c-'a']){
                deque.offer(c);
                onStack[c-'a']=true;
            } 
        }
        String ans="";
        for(char c:deque) ans+=c;
        return ans;
    }
}