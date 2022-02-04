class Solution {
    public int maximumSwap(int num) {
        char[] ch=(num+"").toCharArray();
        
        for(int i=0; i<ch.length; i++){
            int max_index=i;
            int count=0;
            for(int j=i+1; j<ch.length; j++){
                if(ch[j]-'0'==ch[i]-'0') continue; //in case"98368"
                if((ch[j]-'0')>=(ch[max_index]-'0')){//in case"1993"
                    max_index=j;
                    count++;
                }
            }
            if(count>0){
                char temp=ch[i];
                ch[i]=ch[max_index];
                ch[max_index]=temp;
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }
}