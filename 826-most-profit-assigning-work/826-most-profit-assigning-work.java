class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair<Integer, Integer>> works=new ArrayList<>();
        int m=profit.length;
        for(int i=0; i<m; i++){
            works.add(new Pair<>(difficulty[i], profit[i]));
        }
        Collections.sort(works, (a, b)-> a.getKey()-b.getKey());
        Arrays.sort(worker);
        
        int i=0, ans=0, max=0;
        for(int ability:worker){
            while(i<m && works.get(i).getKey()<=ability){
                max=Math.max(max, works.get(i++).getValue());
            }
            ans+=max;
        }
        return ans;          
    }
}