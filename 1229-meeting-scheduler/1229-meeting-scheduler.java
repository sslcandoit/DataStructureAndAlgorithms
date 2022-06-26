class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b)-> a[0]-b[0]);
        Arrays.sort(slots2, (a, b)-> a[0]-b[0]);
        
        List<Integer> ans=new ArrayList<>();
        int m1=slots1.length, m2=slots2.length, p1=0, p2=0;
        while(p1<m1 && p2<m2){
            while(slots1[p1][0]>slots2[p2][1]) p2++;
            while(slots2[p2][0]>slots1[p1][1]) p1++;
            int s=Math.max(slots1[p1][0], slots2[p2][0]);
            int e=Math.min(slots1[p1][1], slots2[p2][1]);
            if(e-s>=duration){
                ans.add(s);
                ans.add(s+duration);
                return ans;
            }
            if(slots1[p1][1]<slots2[p2][1]) p1++;
            else p2++;
        }
        return ans;
    }
}