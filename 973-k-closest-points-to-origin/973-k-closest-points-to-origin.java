class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int m=points.length;
        quickSelect(points, 0, m-1, k);
        return Arrays.copyOf(points, k);
    }
    private void quickSelect(int[][] points, int l, int r, int k){
        if(l>=r) return;
        int pivot=partition(points, l, r);
        if(pivot+1==k) return;
        else if(pivot+1>k) quickSelect(points, l, pivot, k);
        else quickSelect(points, pivot+1, r, k);
    }
    private int partition(int[][] points, int l, int r){
        int[] temp=points[l];
        while(l<r){
            while(l<r && calDistance(points[r])>=calDistance(temp)) r--;
            points[l]=points[r];
            while(l<r && calDistance(points[l])<=calDistance(temp)) l++;
            points[r]=points[l];
        }
        points[l]=temp;
        return l;
    }
    private int calDistance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
    
}