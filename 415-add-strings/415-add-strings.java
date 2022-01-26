class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int i1=num1.length()-1;
        int i2=num2.length()-1;
        
        int num=0;
        int carry=0;
        while(i1>=0 || i2>=0){
            int cur=carry;
            if(i1>=0) cur+=num1.charAt(i1)-'0';
            if(i2>=0) cur+=num2.charAt(i2)-'0';
        
            carry=cur/10;
            sb.append(cur%10);
              
            i1--;
            i2--;
        }
        if(carry>0) sb.append(carry);
        return sb.reverse().toString();
    }
}