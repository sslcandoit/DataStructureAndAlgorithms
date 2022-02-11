class Solution {
    public int minDeletions(String s) {
        int len=s.length();
        
        int[] count=new int[26];
        for(int i=0; i<len; i++) count[s.charAt(i)-'a']++;
        
        Arrays.sort(count);
        
        int need=Integer.MAX_VALUE;
        int res=0;
        for(int j=25; j>=0 && count[j]>0; j--){
            if(need<0) res+=count[j];
            else res+=Math.max(0, count[j]-need);
            
            need=Math.min(count[j], need)-1;
        }
        return res;
    }
}