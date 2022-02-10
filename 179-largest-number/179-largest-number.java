class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        if(n==1) return (nums[0]+"");
        
        String[] str=new String[nums.length];
        for(int i=0; i<n; i++){
            str[i]=nums[i]+"";
        }
        Arrays.sort(str, (a, b)->{
            String s1=a+b;
            String s2=b+a;
            return s2.compareTo(s1);
        });
        if(str[0].equals("0")) return "0";
        
        StringBuilder sb=new StringBuilder();
        for(String s:str) sb.append(s);
        
        return sb.toString();
    }
}