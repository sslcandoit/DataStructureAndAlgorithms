class Solution {
    public int numSteps(String s) {
        if(s.equals("1")) return 0;
        
        int last=s.length()-1;
        if(s.charAt(last)=='0') return 1+numSteps(s.substring(0, last));
        
        int idx=last-1;
        while(idx>=0 && s.charAt(idx)=='1') idx--;
        
        if(idx==-1) return 1+numSteps("1"+"0".repeat(last-idx));
            
        return 1+numSteps(s.substring(0, idx)+"1"+"0".repeat(last-idx));
    }
}