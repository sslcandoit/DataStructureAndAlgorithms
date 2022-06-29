class Solution {
    public int[] minOperations(String boxes) {
        int m=boxes.length();
        
        int[] ans=new int[m];
        for(int i=0, ones=0, count=0; i<m; i++){
            ans[i]+=count;
            ones+=boxes.charAt(i)-'0';
            count+=ones;
        } 
        for(int i=m-1, ones=0, count=0; i>=0; i--){
            ans[i]+=count;
            ones+=boxes.charAt(i)-'0';
            count+=ones;
        } 
        return ans;
    }
}