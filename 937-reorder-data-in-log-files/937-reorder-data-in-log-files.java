class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp=new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                int index1=s1.indexOf(' ');
                int index2=s2.indexOf(' ');
                char c1=s1.charAt(index1+1);
                char c2=s2.charAt(index2+1);
            
                if(c1-'0'<=9){
                    if(c2-'0'<=9) return 0;
                    else return 1;
                }
                if(c2-'0'<=9) return -1;
            
                String sub1=s1.substring(index1+1);
                String sub2=s2.substring(index2+1);
            
                String pre1=s1.substring(0, index1);
                String pre2=s2.substring(0, index2);
            
                if(sub1.compareTo(sub2)==0) return pre1.compareTo(pre2);
                return sub1.compareTo(sub2);
            }
        };
            Arrays.sort(logs, comp);
            return logs;
    }
}