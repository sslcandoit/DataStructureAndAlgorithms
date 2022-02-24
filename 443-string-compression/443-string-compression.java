class Solution {
    public int compress(char[] chars) {
        int len=chars.length;
        if(len==1) return 1;
        
        int i=0;
        int l=0, r=0;
        while(r<len){
            l=r;
            while(r<len && chars[r]==chars[l]) r++;
            int count=r-l;
            if(count==1) chars[i++]=chars[l];
            else{
                chars[i++]=chars[l];
                String str=(count+"");
                int j=0;
                while(j<str.length()) chars[i++]=str.charAt(j++);
            }
        }
        return i;
    }
}