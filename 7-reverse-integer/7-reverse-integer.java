class Solution {
    public int reverse(int x) {
        char[] ch=(x+"").toCharArray();
        
        int l= (ch[0]-'0'>=0 && ch[0]-'0'<=9)? 0:1;
        int r=ch.length-1;
        while(l<r){
            char temp=ch[l];
            ch[l++]=ch[r];
            ch[r--]=temp;
        }
        long num=Long.parseLong(new String(ch));
        if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE) return 0;
        return (int)num;
    }
}