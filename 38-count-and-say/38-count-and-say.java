class Solution {
    public String countAndSay(int n) {
        String say="1";
        
        for(int i=1; i<n; i++){
            StringBuilder sb=new StringBuilder();
            
            char startChar=say.charAt(0);
            int count=1;
            
            for(int j=1; j<say.length(); j++){
                if(say.charAt(j)==startChar) count++;
                else{
                    sb.append(count).append(startChar);
                    count=1;
                    startChar=say.charAt(j);
                }
            }
            sb.append(count).append(startChar);
            say=sb.toString();
        }
        return say;
    }
}