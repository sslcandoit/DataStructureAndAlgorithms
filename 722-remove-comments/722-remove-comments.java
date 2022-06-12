class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();     
        boolean open = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if(open){
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        open = false;
                        i++;       
                    }
                }else{
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') break;
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        open = true;
                        i++;           
                    }else sb.append(s.charAt(i));  
                }
            }
            if(!open && sb.length() > 0){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}