class Solution {
    Integer ans=null;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int i=0; i<baseCosts.length; i++){
            helper(toppingCosts, target, 0, baseCosts[i]);
        }
        return ans;
    }
    public void helper(int[] topping, int target, int i, int cur){
        if(i==topping.length){
            if(this.ans==null 
               || Math.abs(cur-target)<Math.abs(this.ans-target) 
               || (Math.abs(cur-target)==Math.abs(this.ans-target) && cur<this.ans) ) ans=cur;
            return;
        }
        
        helper(topping, target, i+1, cur+topping[i]*2);
        
        helper(topping, target, i+1, cur+topping[i]);
        
        helper(topping, target, i+1, cur);
    }
}