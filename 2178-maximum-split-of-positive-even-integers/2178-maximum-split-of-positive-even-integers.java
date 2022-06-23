class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        LinkedList<Long> ans=new LinkedList<>();
        if(finalSum%2 !=0) return ans;
        
        long cur=2;
        while(cur<=finalSum){
            ans.offer(cur);
            finalSum-=cur;
            cur+=2;
        }
        ans.offer(finalSum+ans.pollLast());
        return ans;
    }
}