class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l=0, r=points.length-1, pivotIndex=points.length;
        while(pivotIndex+1 !=k){
            pivotIndex=partition(points, l, r);
            if(pivotIndex+1<k) l=pivotIndex+1;
            else r=pivotIndex;
        }
        return Arrays.copyOf(points, k);
    }
    private int partition(int[][] points, int l, int r){
        int[] temp=points[l];
        int pivotDist=calDistance(temp);
        while(l<r){
            while(l<r && calDistance(points[r])>=pivotDist) r--;
            points[l]=points[r];
            while(l<r && calDistance(points[l])<=pivotDist) l++;
            points[r]=points[l];
        }
        points[l]=temp;
        return l;
    }
    private int calDistance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
    
}