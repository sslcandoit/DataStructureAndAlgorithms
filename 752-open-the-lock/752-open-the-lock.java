class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> from=new HashSet<>();
        Set<String> to=new HashSet<>();
        Set<String> visited=new HashSet<>(Arrays.asList(deadends));
        
        from.add("0000");
        to.add(target);
        
        int level=0;
        Set<String> temp;
        while(!from.isEmpty() && !to.isEmpty()){
            if(to.size()< from.size()){
                temp=to;
                to=from;
                from=temp;
            }
            temp=new HashSet<>();
            
            for(String s:from){
                if(to.contains(s)) return level;
                if(visited.contains(s)) continue;
                visited.add(s);
                
                for(int i=0; i<4; i++){
                    char c=s.charAt(i);
                    String s1=s.substring(0,i)+(c=='9'? 0:c-'0'+1)+s.substring(i+1);
                    String s2=s.substring(0,i)+(c=='0'? 9:c-'0'-1)+s.substring(i+1);
                    if(!visited.contains(s1)) temp.add(s1);
                    if(!visited.contains(s2)) temp.add(s2);
                }
            }
            level++;
            from=temp;
        }
        return -1;
    }
}