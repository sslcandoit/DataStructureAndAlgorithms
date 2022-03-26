class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int m=word.length(), n=abbr.length();
        int i=0, j=0;
        while(i<m && j<n){
            if(Character.isAlphabetic(abbr.charAt(j))){
                while(i<m && j<n && Character.isAlphabetic(abbr.charAt(j))){
                    if(abbr.charAt(j++)==word.charAt(i++));
                    else return false;
                }
            }else{
                if(j<n && Character.isDigit(abbr.charAt(j)) && abbr.charAt(j)-'0'==0) return false; //word:"a"  abbr="01"
                int num=0;
                while(i<m && j<n &&Character.isDigit(abbr.charAt(j))) num=num*10+(abbr.charAt(j++)-'0');
                i=i+num;
            }
            if((i>m && j<=n) || (i>=m && j<n) || (j==n && i<m)) return false; //"a" "2"      "hi"hi1"/"hi"2i"  
        }
        return true;
    }
}