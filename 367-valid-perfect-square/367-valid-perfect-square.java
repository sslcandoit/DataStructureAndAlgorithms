class Solution {
    public boolean isPerfectSquare(int num) {
        long x=num;
        
        while(x*x>num){
            x=(num/x+x)>>1;
        }
        return x*x==num;
        
        /*
        int target=(num/2)+1;
        
        while(target>=1){
            if(target*target==num) return true;
            target--;
        }
        return false;*/
    }
}