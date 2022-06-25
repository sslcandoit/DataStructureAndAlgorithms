class Solution {
    public boolean buddyStrings(String s, String goal) {
        int len1=s.length(), len2=goal.length();
        if(len1 !=len2) return false;
        
        if(s.equals(goal)){
            Set<Character> set=new HashSet<>();
            for(int i=0; i<len1; i++) set.add(s.charAt(i));
            if(set.size()<len1) return true;
            return false;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<len1; i++){
            if(s.charAt(i) !=goal.charAt(i)) list.add(i);
        }
        return list.size()==2
            && s.charAt(list.get(0))==goal.charAt(list.get(1))
            && s.charAt(list.get(1))==goal.charAt(list.get(0));
    }
}