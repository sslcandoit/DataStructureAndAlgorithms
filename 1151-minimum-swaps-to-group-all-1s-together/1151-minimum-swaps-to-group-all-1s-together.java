class Solution {
    public int minSwaps(int[] data) {
        int countOnes=Arrays.stream(data).sum();
        int remain=Integer.MAX_VALUE;
        
        int sum=0;
        for(int l=0, r=0; r<data.length; r++){
            sum+=data[r];
            if(r-l==countOnes) sum-=data[l++];
            remain=Math.min(remain, countOnes-sum);
        }
        return remain;
    }
}