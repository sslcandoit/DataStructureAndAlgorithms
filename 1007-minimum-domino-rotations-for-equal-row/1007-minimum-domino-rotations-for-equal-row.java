class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        for(int i=0, t=0, b=0; tops[i]==tops[0] || bottoms[i]==tops[0]; i++){
            if(tops[i] !=tops[0]) t++;
            if(bottoms[i] !=tops[0]) b++;
            if(i==n-1) return Math.min(t, b);
        }
        for(int i=0, t=0, b=0; tops[i]==bottoms[0] || bottoms[i]==bottoms[0]; i++){
            if(tops[i] !=bottoms[0]) t++;
            if(bottoms[i] !=bottoms[0]) b++;
            if(i==n-1) return Math.min(t, b);
        }
        return -1;
    }
}