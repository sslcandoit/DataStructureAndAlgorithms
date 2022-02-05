class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0 || denominator==0) return "0";
        
        StringBuilder sb=new StringBuilder();
        if((numerator>0)^(denominator>0)) sb.append("-");
        
        //in case overflow
        long num=Math.abs((long)numerator);
        long denom=Math.abs((long)denominator);
        
        sb.append(num/denom);
        long remainder=num%denom;
        if(remainder==0) return sb.toString();
        
        sb.append(".");
        
        Map<Long, Integer> map=new HashMap<>();
        while(remainder !=0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }else{
                map.put(remainder, sb.length());
                remainder=remainder*10;
                sb.append(remainder/denom);
                remainder=remainder%denom;
            }
        }
        return sb.toString();
    }
}