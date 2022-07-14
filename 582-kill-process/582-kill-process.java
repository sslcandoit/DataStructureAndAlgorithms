class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> kids=new HashMap<>();
        
        for(int i=0; i<ppid.size(); i++){
            kids.putIfAbsent(ppid.get(i), new HashSet<>());
            kids.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> ans=new ArrayList<>();
        if(!kids.containsKey(kill)){
            ans.add(kill);
            return ans;
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.add(kill);
        
        while(!q.isEmpty()){
            int cur=q.poll();
            ans.add(cur);
            
            if(kids.containsKey(cur)){
                for(int kid:kids.get(cur)){
                    q.add(kid);
                }
            }
        }
        return ans;
    }
}