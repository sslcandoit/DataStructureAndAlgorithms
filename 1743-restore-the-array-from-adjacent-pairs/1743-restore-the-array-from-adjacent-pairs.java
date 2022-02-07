class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int m=adjacentPairs.length;
        
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] adj: adjacentPairs){
            int a1=adj[0];
            int a2=adj[1];
            
            if(!map.containsKey(a1)) map.put(a1, new ArrayList<>());
            map.get(a1).add(a2);
            if(!map.containsKey(a2)) map.put(a2, new ArrayList<>());
            map.get(a2).add(a1);
        }
        int head=0;
        for(int key:map.keySet()){
            if(map.get(key).size()==1){
                head=key;
                break;
            }
        }
        int[] ans=new int[m+1];
        Set<Integer> visited=new HashSet<>();
        dfs(visited, map, head, ans, 0);
        return ans;
    }
    private void dfs(Set<Integer> visited, Map<Integer, List<Integer>> map, int num, int[] ans, int i){
        if(!visited.contains(num)){
            visited.add(num);
            ans[i]=num;
            List<Integer> list=map.get(num);
            for(int l:list) dfs(visited, map, l, ans, i+1);
        }else return;
    }
}