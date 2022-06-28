class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<List<Integer>> temp=new PriorityQueue<>((a, b)-> (a.get(0)+a.get(1))-(b.get(0)+b.get(1)));
        
        List<Integer> list=new ArrayList<>();
        for(int j=0; j<nums2.length; j++){
            list.add(nums1[0]);
            list.add(nums2[j]);
            list.add(0);
            temp.add(new ArrayList<>(list));
            list.clear();
        }
        while(k-- >0 && !temp.isEmpty()){
            List<Integer> cur=temp.poll();
            if(cur.get(2)+1 <nums1.length){
                list.add(nums1[cur.get(2)+1]);
                list.add(cur.get(1));
                list.add(cur.get(2)+1);
                temp.add(new ArrayList<>(list));
                list.clear();
            }
            cur.remove(2);
            ans.add(new ArrayList<>(cur));
        }
        /*
        [0,0,0,0,0,2,2,2,2]
        [-3,22,35,56,76]         22
        
        [[0,-3],[0,-3],[0,-3],[0,-3],[0,-3],
        [2,-3],[2,-3],[2,-3],[2,-3],
        [0,22],[0,22],[0,22],[0,22],[0,22],
        [2,22],[2,22],[2,22],[2,22],
        [0,35],[0,35],[0,35],[0,35]]
        */
        return ans;
    }
}