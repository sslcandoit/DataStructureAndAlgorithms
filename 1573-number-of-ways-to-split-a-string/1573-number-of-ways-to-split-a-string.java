class Solution {
    public int numWays(String s) {
        long len=s.length();
        long countOne=0;
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='1') countOne++;
        }
        if(countOne%3 !=0) return 0;
        if(countOne==0) return (int)((len-2)*(len-1)/2 % 1000000007);
            
        countOne=countOne/3; 
        
        long countFirstSub=0, countSecondSub=0, count=0;
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='1') count++;
            
            if(count==countOne) countFirstSub++;
            else if(count==2*countOne) countSecondSub++;
        }
        return (int)(countFirstSub * countSecondSub % 1000000007);
    }
    /*
    00000
    0 0 000
    0 00 00
    0 000 0
    00 0 00
    00 00 0
    000 0 0
    (5-2)*(5-1)/2=6 */
}