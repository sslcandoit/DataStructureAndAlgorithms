class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str=String.join(" ", sentence)+" ";
        
        int index=0, len=str.length();
        for(int i=0; i<rows; i++){
            index+=cols;
            
            while(index> 0 && str.charAt(index%len) != ' ') index--;
            
            index++;
        }
        return index/len;
    }
}