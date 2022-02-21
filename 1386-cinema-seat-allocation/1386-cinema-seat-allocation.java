class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int[] r:reservedSeats){
            int row=r[0];
            int seat=r[1];
            map.put(row, map.getOrDefault(row, 0)|(1<<seat));
        }
        int sum=0;
        for(int row: map.keySet()){
            int seats=map.get(row);
            int subSum=0;
            if((seats&60)==0) subSum+=1;
            if((seats&960)==0) subSum+=1;
            if((seats&240)==0 && subSum==0) subSum=1;
            sum+=subSum;
        }
        return (n-map.size())*2+sum;
    }
    /*
   1111000000(960) 111100 (60)  11110000(240)
    */
}