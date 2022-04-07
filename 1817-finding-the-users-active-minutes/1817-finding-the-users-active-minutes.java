class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int[] log:logs){
            int id=log[0];
            int time=log[1];
            if(!map.containsKey(id)) map.put(id, new HashSet<>());
            map.get(id).add(time);
        }
        int[] ans=new int[k];
        for(Set<Integer> set:map.values()){
            ans[set.size()-1]++;
        }
        return ans;
    }
}