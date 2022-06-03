class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // step1:
        int area1=(ax2-ax1)*(ay2-ay1);
        int area2=(bx2-bx1)*(by2-by1);
        
        // step2.1: width 左边界相对靠右的， 右边界相对靠左的
        int leftMax=Math.max(ax1, bx1);
        int rightMin=Math.min(ax2, bx2);
        // step2.2: hight 上边界相对靠下的， 下边界相对靠上的
        int topMin=Math.min(ay2, by2);
        int bottomMax=Math.max(ay1, by1);
        // step 2.3:
        int overlap=0;
        if(leftMax<rightMin && topMin>bottomMax) overlap=(rightMin-leftMax)*(topMin-bottomMax);
        
        return area1+area2-overlap;
    }
}