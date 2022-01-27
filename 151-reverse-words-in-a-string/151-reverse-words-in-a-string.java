class Solution {
    public String reverseWords(String s) {
        char[] ch=reverse(s.toCharArray(), 0, s.length()-1);
        
        int l=0, r=0;
        for(int i=0; i<s.length(); i++){
            if(ch[i] !=' ') ch[r++]=ch[i];
            else if(i>0 && ch[i-1] !=' '){
                reverse(ch, l, r-1);
                ch[r]=' ';
                r++;
                l=r;
            }
        }
        reverse(ch, l, r-1);//ch: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","k","s"," "," "] l=12, r=12
        return new String(ch, 0, (r!=0 && ch[r-1] ==' ')? r-1:r);
    }
    private char[] reverse(char[] arr, int i, int j){
        while(i<j){
            char temp=arr[i];
            arr[i++]=arr[j];
            arr[j--]=temp;
        }
        return arr;
    }
}