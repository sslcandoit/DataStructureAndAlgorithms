class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map=new HashMap<>();
        
        int i=0;
        while(i<s.length()){
            for(int r=0; r<numRows && i<s.length(); r++, i++){
                if(!map.containsKey(r)) map.put(r, new StringBuilder());
                map.get(r).append(s.charAt(i));
            }
            for(int j=numRows-2; j>0 && i<s.length(); j--, i++){
                map.get(j).append(s.charAt(i));
            }
        }
        StringBuilder sb=map.get(0);
        for(int row=1; row<numRows; row++){
            if(map.containsKey(row)) sb.append(map.get(row));
        }
        return sb.toString();
    }
}