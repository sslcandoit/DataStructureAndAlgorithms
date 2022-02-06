class Solution {
    public int maxProfit(int[] inventory, int orders) {
        // n*(an+a1)/2
        int mod=1000000007;
        Arrays.sort(inventory);
        
        int len=inventory.length;
        int i=len-1;
        int cur=inventory[i];
        
        long profit=0;
        //[1,3,5,5,9,9,9]
        while(orders>0){
            while(i>=0 && inventory[i]==cur) i--;
            int next= i>=0? inventory[i]:0;
            
            int numSameQuantity=len-1-i;
            int n=cur-next;
            
            int curAvailable=n*numSameQuantity;
            if(curAvailable<=orders){
                profit+=(long)(cur+next+1)*n/2*numSameQuantity;
            }else{
                int availableFullRow=orders/numSameQuantity;//from 5->2 or from 5->4
                int remainder=orders%numSameQuantity;
                
                profit+=(long)(cur+(cur-availableFullRow)+1)*availableFullRow/2*numSameQuantity;
                profit+=(long)remainder*(cur-availableFullRow);
            }
            orders-=curAvailable;
            profit=profit%mod;
            cur=next;
        }
        return (int)profit;
    }
}