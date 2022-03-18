class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len=flowerbed.length;
        for(int i=0; i<len && n>0; i++){
            if(flowerbed[i]==1) continue;
            int pre=(i==0)? 0:flowerbed[i-1];
            int nxt=(i==len-1)? 0:flowerbed[i+1];
            if(pre==0 && nxt==0){
                flowerbed[i]=1;
                n--;
            }
        }
        return n==0;
    }
}