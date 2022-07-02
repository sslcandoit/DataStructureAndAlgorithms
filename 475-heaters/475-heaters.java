class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans=0;
        for(int h:houses){
            int index=Arrays.binarySearch(heaters, h);
            
            if(index<0){
                index=~index;
                int disL= (index-1>=0)? h-heaters[index-1] : Integer.MAX_VALUE;
                int disR= (index<heaters.length)? heaters[index]-h : Integer.MAX_VALUE;
                ans=Math.max(ans, Math.min(disL, disR));
            }
        }
        return ans;
    }
}