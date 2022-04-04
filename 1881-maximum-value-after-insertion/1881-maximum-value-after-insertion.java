class Solution {
    public String maxValue(String n, int x) {
       boolean postive=true;
        if(n.charAt(0)=='-'){
            postive=false;
            n=n.substring(1);
        } 
        for(int i=0; i<n.length(); i++){
            int num=n.charAt(i)-'0';
            
            if(postive && x>num || !postive && x<num){
                return (postive? "":"-")+n.substring(0, i)+x+n.substring(i);
            }
        }
        return (postive? "":"-")+n+x;
    }
}