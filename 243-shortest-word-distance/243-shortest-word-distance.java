class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1=-1, index2=-1, min=Integer.MAX_VALUE;
        
        for(int i=0; i<wordsDict.length; i++){
            String str=wordsDict[i];
            if(str.equals(word1)) index1=i;
            else if(str.equals(word2)) index2=i;
            
            if(index1 !=-1 && index2 !=-1) min=Math.min(min, Math.abs(index1-index2));
        }
        return min;   
    }
}