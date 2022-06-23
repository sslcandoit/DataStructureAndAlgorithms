class Solution {
    public String reverseVowels(String s) {
        String vowels="aeiouAEIOU";
        char[] chars=s.toCharArray();
        
        int l=0, r=s.length()-1;
        while(l<r){
            while(l<r && !vowels.contains(chars[l]+"")) l++;
            while(l<r && !vowels.contains(chars[r]+"")) r--;
            
            if(l>=r) break;
            
            char temp=chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}