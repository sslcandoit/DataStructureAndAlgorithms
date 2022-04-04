class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        int size=heights.length;
        int i=k;
        while(volume-- >0){
            while(i>0 && heights[i]>=heights[i-1]) i--;
            
            while(i<size-1 && heights[i]>=heights[i+1]) i++;
            
            while(i>k && heights[i]>=heights[i-1]) i--;
            
            heights[i]++;
        }
        return heights;
    }
}