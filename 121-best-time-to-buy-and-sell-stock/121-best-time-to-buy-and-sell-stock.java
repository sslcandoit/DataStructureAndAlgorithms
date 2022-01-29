class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int buyIn=Integer.MAX_VALUE;
        int maxProfit=0;
        
        for(int p:prices){
            if(p<buyIn) buyIn=p;
            else if(p>buyIn) maxProfit=Math.max(maxProfit, p-buyIn);
        }
        return maxProfit;
    }
}