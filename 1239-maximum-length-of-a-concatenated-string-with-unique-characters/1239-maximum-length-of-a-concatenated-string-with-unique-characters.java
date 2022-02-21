class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> list=new ArrayList<>();
        list.add(0);
        int ans=0;
        for(String s:arr){
            int mask=0, temp=0;
            for(char c:s.toCharArray()){
                temp=mask&(1<<(c-'a'));
                if(temp>0) break;
                mask=mask|(1<<(c-'a'));
            }
            if(temp>0) continue;
            for(int i=list.size()-1; i>=0; i--){
                if((mask&(list.get(i)))==0){
                    list.add(mask|(list.get(i)));
                    ans=Math.max(ans, Integer.bitCount(mask|(list.get(i))));
                } 
            }
        }
        return ans;
    }
}