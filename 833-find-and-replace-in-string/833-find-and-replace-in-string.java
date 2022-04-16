class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int m=s.length();
         List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indices.length; i++) sorted.add(new int[]{indices[i], i});
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String str = sources[j], t = targets[j];
            if (i+str.length()<=m && s.substring(i, i + str.length()).equals(str)) s = s.substring(0, i) + t + s.substring(i + str.length());
        }
        return s;
    }
    /*
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int m=s.length();
        int[] match=new int[m];
        Arrays.fill(match, -1);
        
        for(int i=0; i<indices.length; i++){
            int index=indices[i];
            if(index+sources[i].length()<=m && s.substring(index, index+sources[i].length()).equals(sources[i])) match[index]=i;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<m;){
            if(match[i] !=-1){
                sb.append(targets[match[i]]);
                i+=sources[match[i]].length();
            }else sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
    */
}