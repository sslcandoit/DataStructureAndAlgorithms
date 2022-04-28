class Solution {
    public int minSwaps(String s) {
        int countLeft=0;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='[') countLeft++;
            else if(c==']' && countLeft>0) countLeft--;
        }
        return (countLeft+1)/2;
    }
}