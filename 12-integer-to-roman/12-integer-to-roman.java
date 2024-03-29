class Solution {
    public String intToRoman(int num) {
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(num>0 && i<value.length){
            if(num>=value[i]){
                num-=value[i];
                sb.append(roman[i]);
            }else i++;
        }
        return sb.toString();
    }
}