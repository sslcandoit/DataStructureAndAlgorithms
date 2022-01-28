class Solution {
    /*
    zero  z-0                 1
    one   o-1//0,2,4          2
    two   w-2                 1
    three h-3//8 
    four  u-4
    five  f-5//4
    six   x-6
    seven s-7//6
    eight g-8
    nine  i-9 //5, 6, 8,
    */
    public String originalDigits(String s) {
        int[] count=new int[10];
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c=='z') count[0]++;
            else if(c=='w') count[2]++;
            else if(c=='u') count[4]++;
            else if(c=='x') count[6]++;
            else if(c=='g') count[8]++;
            else if(c=='o') count[1]++;
            else if(c=='h') count[3]++;
            else if(c=='f') count[5]++;
            else if(c=='s') count[7]++;
            else if(c=='i') count[9]++;
        }
        count[1]=count[1]-count[0]-count[2]-count[4];
        count[3]-=count[8];
        count[5]-=count[4];
        count[7]-=count[6];
        count[9]=count[9]-count[5]-count[6]-count[8];
        
        StringBuilder sb=new StringBuilder();
        for(int j=0; j<10; j++){
            for(int k=0; k<count[j]; k++) sb.append(j);
        }
        return sb.toString();
    }
}