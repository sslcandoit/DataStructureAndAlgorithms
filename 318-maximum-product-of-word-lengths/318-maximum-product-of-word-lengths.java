class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] bianry=new int[n];
        
        for(int i=0; i<n; i++){
            String cur=words[i];
            for(int j=0; j<cur.length(); j++){
                bianry[i]|=(1<<(cur.charAt(j)-'a'));
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if( (bianry[i] & bianry[j])==0 && (words[i].length()*words[j].length())>ans){
                    ans=words[i].length() * words[j].length();
                }
            }
        }
        return ans;
    }
}