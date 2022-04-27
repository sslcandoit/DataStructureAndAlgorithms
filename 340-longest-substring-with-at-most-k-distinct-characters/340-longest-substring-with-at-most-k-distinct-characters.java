class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> count=new HashMap<>();
        
        int ans=0;
        for(int i=0, j=0; j<s.length(); j++){
            char c=s.charAt(j);
            count.put(c, count.getOrDefault(c, 0)+1);
            
            while(count.size()>k){
                char cc=s.charAt(i);
                count.put(cc, count.get(cc)-1);
                if(count.get(cc)==0) count.remove(cc);
                i++;
            } 
            ans=Math.max(ans, j-i+1);
        }
        return ans;
    }
}