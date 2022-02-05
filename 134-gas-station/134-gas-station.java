class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0 || cost.length==0 || gas==null || cost==null) return -1;
        
        int balance=0;
        int cur=0;
        int startPoint=0;
        
        for(int i=0; i<gas.length; i++){
            cur+=gas[i]-cost[i];
            balance+=gas[i]-cost[i];
            
            if(cur<0){
                startPoint=i+1;
                cur=0;
            }
        }
        return balance>=0? startPoint:-1;
    }
}