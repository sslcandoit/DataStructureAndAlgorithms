class Solution {
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        int[] count=new int[n];
        char[] c=s.toCharArray();
        
        int l=0;
        for(int r=0; r<n; r++, l++){
            c[l]=c[r];
            
            count[l]= (l>0 && c[l-1]==c[r])? count[l-1]+1 : 1;
            if(count[l]==k) l-=k;
        }
        return new String(c, 0, l);
    }
}