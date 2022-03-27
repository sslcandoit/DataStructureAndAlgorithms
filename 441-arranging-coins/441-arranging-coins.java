class Solution {
    public int arrangeCoins(int n) {
        int row=1;
        while(true){
            n-=row;
            if(n<row+1) break;
            row++;
        }
        return row;
    }
}