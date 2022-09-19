class Solution {
    public int lengthOfLastWord(String s) {
        String[] words=s.split(" ");
        
        int len=words.length;
        int size=0;
        
        for(int i=len-1; i>=0; i--){
            size=words[i].length();
            
            if(size==0) continue;
            else break;
        }
        return size;
    }
}