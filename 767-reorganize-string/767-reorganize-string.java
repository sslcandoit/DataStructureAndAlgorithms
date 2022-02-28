class Solution {
    public String reorganizeString(String s) {
        int[] count=new int[26];
        for(int i=0; i<s.length(); i++) count[s.charAt(i)-'a']++;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> b[1]-a[1]);
        for(int i=0; i<26; i++){
            if(count[i]>0) pq.offer(new int[]{i, count[i]});
        }
        if(pq.peek()[1]>(s.length()+1)/2) return "";
        
        String ans="";
        while(pq.size()>=2){
            int[] a=pq.poll();
            int[] b=pq.poll();
            
            ans+=(char)(a[0]+'a');
            ans+=(char)(b[0]+'a');
            
            a[1]--;
            b[1]--;
            
            if(a[1]>0) pq.offer(a);
            if(b[1]>0) pq.offer(b);
        }
        if(pq.size()==1) ans+=(char)(pq.poll()[0]+'a');
        return ans;
    }
}