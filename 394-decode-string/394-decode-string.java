class Solution {
    private int i=0;
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder();
        
        while(i<s.length() && s.charAt(i) !=']'){
            if(Character.isDigit(s.charAt(i))){
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) num=num*10+(s.charAt(i++)-'0');
                
                i++;//skip [
                
                String str=decodeString(s);
                while(num-- > 0) sb.append(str);
                
                i++;//skip ]
            }else sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
}