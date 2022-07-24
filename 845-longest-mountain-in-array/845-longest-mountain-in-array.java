class Solution {
    public int longestMountain(int[] arr) {
        int res = 0, left = 0, right = 0;
        
        for (int i = 1; i < arr.length; ++i) {
            if ( (right > 0 && arr[i - 1] < arr[i]) || arr[i-1]==arr[i]) left =right = 0;
            
            if (arr[i - 1] < arr[i]) left++;
            if (arr[i - 1] > arr[i]) right++;
            
            if (left > 0 && right > 0) res = Math.max(res, left + right + 1);
        }
        return res;
    }
}//[0,2,0,2,1,2,3,4,4,1]