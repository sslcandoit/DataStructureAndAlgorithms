class Solution {
    public String validIPAddress(String queryIP) {
        String[] ip4= queryIP.split("\\.",-1);
        String[] ip6= queryIP.split("\\:",-1);
        if(queryIP.chars().filter(c -> c=='.').count()==3){
            for(String p4:ip4){
                if(isIP4(p4)) continue;
                else return "Neither";
            }
            return "IPv4";
        }
        if(queryIP.chars().filter(c ->c==':').count()==7){
            for(String p6:ip6){
                if(isIP6(p6)) continue;
                else return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
    private boolean isIP4(String str){
        try{return String.valueOf(Integer.valueOf(str)).equals(str) && Integer.parseInt(str)>=0 && Integer.parseInt(str)<=255;
        }catch(NumberFormatException e){
            return false;
        }
    }
    private boolean isIP6(String str){
        if(str.length()>4) return false;
        try{return Integer.parseInt(str, 16)>=0 && str.charAt(0) !='-';
        }catch(NumberFormatException e){
            return false;
        }
    }
}