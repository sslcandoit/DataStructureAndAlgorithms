class Solution {
    public boolean isPerfectSquare(int num) {
        int target=(num/2)+1;
        
        while(target>=1){
            if(target*target==num) return true;
            target--;
        }
        return false;
    }
}