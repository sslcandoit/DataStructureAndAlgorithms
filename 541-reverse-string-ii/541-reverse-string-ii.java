class Solution {
    public String reverseStr(String s, int k) {
        int len=s.length();
        if(len<=k) return reverse(s, 0, len-1);
        if(len<=2*k) return reverse(s, 0, k-1);
        
        String ans=reverse(s.substring(0, 2*k), 0, k-1)+reverseStr(s.substring(2*k), k);
        
        return ans;
    }
    private String reverse(String s, int l, int r){
        char[] chars=s.toCharArray();
        
        while(l<r){
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}