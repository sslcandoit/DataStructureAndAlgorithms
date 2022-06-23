class Solution {
    public boolean isStrobogrammatic(String num) {
        int l=0, r=num.length()-1;
        while(l<=r){
            String s=""+num.charAt(l)+num.charAt(r);
            if(!"00 11 88 69 96".contains(s)) return false;
            l++;
            r--;
        }
        return true;
        /*
        Map<Character, Character> map=new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        
        int l=0, r=num.length()-1;
        while(l<=r){
            if(!map.containsKey(num.charAt(l)) || map.get(num.charAt(l)) !=num.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
        */
    }
}