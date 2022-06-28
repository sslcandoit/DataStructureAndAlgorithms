class Solution {
    public int minSwaps(int[] data) {
        int maxWin = 0, width = Arrays.stream(data).sum(); // count the number of 1's in data.
        for (int l = -1, r = 0, cntWin = 0; r < data.length; ++r) {
            cntWin += data[r];
            if (r - l > width) { cntWin -= data[++l]; } // wider than width, shrink the lower bound to maintain its width.
            maxWin = Math.max(cntWin, maxWin);
        }
        return width - maxWin;
    }
}