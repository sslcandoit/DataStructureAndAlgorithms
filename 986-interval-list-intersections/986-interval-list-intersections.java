class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1=firstList.length, len2=secondList.length;
        if(len1==0 || len2==0) return new int[0][0];
        
        List<int[]> list=new ArrayList<>();
        int i=0, j=0;
        while(i<len1 && j<len2){
            int[] a=firstList[i];
            int[] b=secondList[j];
            
            int max=Math.max(a[0], b[0]);
            int min=Math.min(a[1], b[1]);
            
            if(max<=min) list.add(new int[]{max, min});
            
            if(a[1]==min) i++;
            else j++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}