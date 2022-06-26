class Solution {
    public String reverseWords(String s) {
        String[] strs=s.split(" ");
        for(int i=0; i<strs.length; i++){
            strs[i]=reverse(strs[i]);
        }
        return String.join(" ", strs);
    }
    private String reverse(String s){
        int l=0, r=s.length()-1;
        char[] c=s.toCharArray();
        while(l<r){
            char temp=c[l];
            c[l]=c[r];
            c[r]=temp;
            l++;
            r--;
        }
        return new String(c);
    }
}