class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative=false;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) isNegative=true;
        
        long dividendL=Math.abs((long)dividend), divisorL=Math.abs((long)divisor);
        if(dividendL<divisorL || dividendL==0 || divisorL==0) return 0;
        
        long ans=0;
        int shift=31;
        while(dividendL>=divisorL){
            while(dividendL< (divisorL<<shift)) shift--;
            dividendL-= (divisorL<<shift);
            ans+= (1<<shift);
        }
        if(ans<0) return isNegative? Integer.MIN_VALUE:Integer.MAX_VALUE;
        return isNegative? (int)-ans:(int)ans;
    }/*
    public int divide(int dividend, int divisor) {
        int sign=1;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) sign=-1;
        
        long dividendL=Math.abs((long)dividend), divisorL=Math.abs((long)divisor);
        if(dividendL<divisorL || dividendL==0 || divisorL==0) return 0;
        
        long ans=helper(dividendL, divisorL);
        if(ans>Integer.MAX_VALUE) return (sign==1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
        return (int)ans*sign;
    }
    private long helper(long dividend, long divisor){
        if(dividend<divisor) return 0;
        long multiple=1, sum=divisor;
        while(sum+sum<=dividend){
            sum+=sum;
            multiple+=multiple;
        }
        return multiple+helper(dividend-sum, divisor);
    }
    */
}