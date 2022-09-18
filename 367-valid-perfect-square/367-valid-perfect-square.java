class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        
        long guess=num/2;
        while(guess*guess>num){
            guess=(num/guess+guess)>>1;
        }
        return guess*guess==num;
        /*
        long x=num;
        
        while(x*x>num){
            x=(num/x+x)>>1;
        }
        return x*x==num;
        
        *******************************************************
        int target=(num/2)+1;
        
        while(target>=1){
            if(target*target==num) return true;
            target--;
        }
        return false;*/
    }
}