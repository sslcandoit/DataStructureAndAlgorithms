class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)-> b[1]-a[1]);
        int count=0;
        for(int[] arr:boxTypes){
            int numOfBox=arr[0];
            if(numOfBox<=truckSize){
                count+=numOfBox*arr[1];
                truckSize-=numOfBox;
            }else{
                count+=truckSize*arr[1];
                truckSize-=truckSize;
            }
            if(truckSize==0) break;
        }
        return count;
    }
}