class Solution {
    public int maxProfit(int[] prices) {
        int rest=0, sold=0, hold=Integer.MIN_VALUE;
        for(int p:prices){
            int pre_hold=hold;
            hold=Math.max(pre_hold, rest-p);
            rest=Math.max(rest, sold);
            sold=pre_hold+p;
        }
        return Math.max(sold, rest);
    }
}