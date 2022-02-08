class Solution {
    public List<String> commonChars(String[] words) {
        int[] count=new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String w:words){
            int[] cnt=new int[26];
            w.chars().forEach(c-> cnt[c-'a']++);
            IntStream.range(0,26).forEach(i->count[i]=Math.min(count[i], cnt[i]));
        }
       
        List<String> ans=new ArrayList<>();
        for(char c='a'; c<='z'; c++){
            while(count[c-'a']-->0) ans.add(c+"");
        }
        return ans;
    }
}