class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        
        int[] product=new int[len1+len2];//999*999=998001, so the maxLen is len1+len2
        
        int res=0;
        for(int i1=len1-1; i1>=0; i1--){
            int digit1=num1.charAt(i1)-'0';
            for(int i2=len2-1; i2>=0; i2--){
                int digit2=num2.charAt(i2)-'0';
                
                int posPre=i1+i2;
                int posPos=i1+i2+1;
                
                int cur=digit1*digit2+product[posPre]*10+product[posPos];
                product[posPre]=cur/10;
                product[posPos]=cur%10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int n:product){
            if(sb.length()==0 && n==0) continue;
            sb.append(n);
        }
        return sb.length()==0? "0": sb.toString();
    }
}