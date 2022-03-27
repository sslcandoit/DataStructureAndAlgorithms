class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        helper(s, list, "", 4, 0);
        return list;
    }
    private void helper(String s, List<String> list, String cur, int remain, int index){
        if(remain==0){
            if(index==s.length()) list.add(cur);
            return;
        }
        for(int i=1; i<=3; i++){
            if(index+i>s.length()) break;
            if(i !=1 && s.charAt(index)=='0') break;
            
            String temp=s.substring(index, index+i);
            int num=Integer.parseInt(temp);
            
            if(num<=255) helper(s, list, cur+temp+(remain==1? "":"."), remain-1, index+i);
        }
    }
}