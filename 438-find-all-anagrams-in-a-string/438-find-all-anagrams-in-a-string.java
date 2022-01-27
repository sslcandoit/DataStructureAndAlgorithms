class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        
        int[] pp=new int[26];
        int[] ss=new int[26];
        
        for(int i=0; i<p.length(); i++) pp[p.charAt(i)-'a']++;
        
        int l=0;
        int r=p.length();
        int i=l;
        while(i<s.length()){
            ss[s.charAt(i)-'a']++;
            i++;
            if(i==r){
                if(Arrays.equals(pp, ss)) ans.add(l);
                ss[s.charAt(l)-'a']--;
                l++;
                r++;
            }
        }
        return ans;
    }
}