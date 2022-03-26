class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
        if(a>0) pq.add(new int[]{0, a});
        if(b>0) pq.add(new int[]{1, b});
        if(c>0) pq.add(new int[]{2, c});
        
        StringBuilder sb=new StringBuilder();
  
        while(pq.size()>1){
            int[] big=pq.poll();
            char l=(char)(big[0]+'a');
            if(big[1]>=2){
                sb.append(l).append(l);
                big[1]-=2;
            }else{
                sb.append(l);
                big[1]--;
            }
            
            int[] small=pq.poll();
            char s=(char)(small[0]+'a');
            if(big[1]<small[1] && small[1]>1){
                sb.append(s).append(s);
                small[1]-=2;
            }else{
                sb.append(s);
                small[1]--;
            }
            
            if(big[1]>0) pq.add(big);
            if(small[1]>0) pq.add(small);
        }
        while(!pq.isEmpty() && ((sb.length()>0 && pq.peek()[0]+'a' !=sb.charAt(sb.length()-1)) || sb.length()==0)){
            int[] temp=pq.poll();
            char t=(char)(temp[0]+'a');
            if(temp[1]>1) sb.append(t).append(t);
            else sb.append(t);
        }
        return sb.toString();
    }
}