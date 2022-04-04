class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minAbs=Integer.MAX_VALUE;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1; i<arr.length; i++){
            int cur=arr[i]-arr[i-1];
            if(cur<minAbs){
                minAbs=cur;
                ans.clear();
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }else if(cur==minAbs){
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}