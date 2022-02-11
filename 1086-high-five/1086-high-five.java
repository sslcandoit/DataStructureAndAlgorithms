class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        for(int[] item:items){
            int id=item[0];
            if(!map.containsKey(id)) map.put(id, new ArrayList<>());
            map.get(id).add(item[1]);
        }
        
        int[][] ans=new int[map.size()][2];
        int j=0;
        for(int key:map.keySet()){
            List<Integer> score=map.get(key);
           Collections.sort(score, (a,b)-> b-a);
            int sum=0;
            for(int i=0; i<5; i++) sum+=score.get(i);
            ans[j++]=new int[]{key, sum/5};
        }
        return ans;
    }
}