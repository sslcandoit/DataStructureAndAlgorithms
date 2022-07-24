class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len=s.length();
        int[] parent=new int[len];
        
        for(int i=0; i<len; i++){
            parent[i]=i;
        }
        for(List<Integer> list:pairs){
            union(parent, list.get(0), list.get(1));
        }
        
        Map<Integer, PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0; i<len; i++){
            char c=s.charAt(i);
            int p=find(parent, i);
            map.putIfAbsent(p, new PriorityQueue<>());
            map.get(p).add(c);
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<len; i++){
            int p=find(parent, i);
            sb.append(map.get(p).poll());
        }
        return sb.toString();
    }
    private int find(int[] parent, int x){
        if(parent[x]==x) return x;
        return find(parent, parent[x]);
    }
    private void union(int[] parent, int a, int b){
        int parentA=find(parent, a);
        int parentB=find(parent, b);
        
        if(parentA<parentB) parent[parentB]=parentA;
        else parent[parentA]=parentB;
    }
}