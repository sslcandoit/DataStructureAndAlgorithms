class Solution {
    public String reverseStr(String s, int k) {
        int len=s.length();
        char[] chars=s.toCharArray();
        
        for(int i=0; i<len; i+=2*k){
            int r=Math.min(i+k-1, len-1);
            reverse(chars, i, r);
        }
        
        return new String(chars);
    }
    private void reverse(char[] chars, int l, int r){
        while(l<r){
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
    }
}