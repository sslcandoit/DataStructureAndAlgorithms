class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] index1=new int[256], index2=new int[256];
        
        for(int i=0; i<s.length(); i++){
            if(index1[s.charAt(i)] != index2[t.charAt(i)]) return false;
            index1[s.charAt(i)]=1+i;
            index2[t.charAt(i)]=1+i;
        }
        return true;
    }
}