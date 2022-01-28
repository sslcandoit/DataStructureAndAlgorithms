class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=1; i<words.length; i++){
            String pre=words[i-1], cur=words[i];
            int len1=pre.length(), len2=cur.length();
            
            int j;
            for(j=0; j<Math.min(len1, len2); j++){
                int index1=order.indexOf(pre.charAt(j));
                int index2=order.indexOf(cur.charAt(j));
                if(index1> index2) return false;
                if(index1< index2) break;
            }
            if(j==len2 && len1>j) return false;
        }
        return true;
    }
}