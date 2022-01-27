class Solution {
    public int myAtoi(String s) {
        int len=s.length();
        int i=0;
        while(i<len && s.charAt(i)==' ') i++;
        if(i==len) return 0;
        
        int sign=1;
        char c=s.charAt(i);
        if(c=='+' || c=='-'){
            if(c=='-') sign=-1;
            i++;
        }
        
        int num=0;
        while(i<len){
            int digit=s.charAt(i)-'0';
            if(digit>9 || digit<0) break;
            
            int temp=num*10+digit;
            if(temp/10 !=num) return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            num=temp;
            i++;
        }
        return sign*num;
    }
}