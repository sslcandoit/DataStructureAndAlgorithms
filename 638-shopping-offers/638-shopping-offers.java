class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price, special, needs, 0);
    }
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index){
        int n=price.size(), ans=0;
        for(int i=0; i<n; i++) ans+=price.get(i)*needs.get(i);
        
        for(int i=0; i<special.size(); i++){
            List<Integer> s=special.get(i);
            List<Integer> tempNeeds=new ArrayList<>();
            for(int j=0; j<n; j++){
                if(s.get(j)>needs.get(j)){
                    tempNeeds=null;
                    break;
                }else tempNeeds.add(needs.get(j)-s.get(j));
            }
            if(tempNeeds !=null) ans=Math.min(ans, s.get(n)+helper(price, special, tempNeeds, i));
        }
        return ans;
    }
}