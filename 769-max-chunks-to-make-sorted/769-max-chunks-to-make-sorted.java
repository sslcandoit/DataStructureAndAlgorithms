class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max=0;
        int splits=0;
        for(int i=0; i<arr.length; i++){
            max=Math.max(max, arr[i]);
            if(max==i) splits++;
        }
        return splits;
    }
    /*
    For example,
        original: 0, 2, 1, 4, 3, 5, 7, 6
        max:      0, 2, 2, 4, 4, 5, 7, 7
        sorted:   0, 1, 2, 3, 4, 5, 6, 7
        index:    0, 1, 2, 3, 4, 5, 6, 7
        
 The chunks are: 0 | 2, 1 | 4, 3 | 5 | 7, 6
    */
}