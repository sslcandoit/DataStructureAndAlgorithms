class Solution {
    public int[] minOperations(String boxes) {
        int m=boxes.length();
        
        int[] left=new int[m];
        int count=boxes.charAt(0)-'0';
        for(int i=1; i<m; i++){
            left[i]=left[i-1]+count;
            count+=boxes.charAt(i)-'0';
        } 
        
        int[] right=new int[m];
        count=boxes.charAt(m-1)-'0';
        for(int i=m-2; i>=0; i--){
            right[i]=right[i+1]+count;
            count+=boxes.charAt(i)-'0';
        } 
        
        int[] ans=new int[m];
        for(int i=0; i<m; i++) ans[i]=left[i]+right[i];
        
        return ans;
    }
}