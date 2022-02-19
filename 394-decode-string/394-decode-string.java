class Solution {
    public String decodeString(String s) {
        String string="";
        Stack<Integer> num=new Stack<>();
        Stack<String> str=new Stack<>();
        
        int i=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                int n=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))) n=n*10+s.charAt(i++)-'0';
                num.push(n);
            }else if(s.charAt(i)=='['){
                str.push(string);
                string="";
                i++;
            }else if(s.charAt(i)==']'){
                StringBuilder sb=new StringBuilder(str.pop());
                int number=num.pop();
                while(number-- >0) sb.append(string); 
                string=sb.toString();
                i++;
            }else string=string+s.charAt(i++);
        }
        return string.toString();
    }
    /*
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
    }*/
}