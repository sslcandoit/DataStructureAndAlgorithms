class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=Arrays.stream(matchsticks).sum();
        if(sum%4 !=0) return false;
        
        int edge=sum/4;
        
        Arrays.sort(matchsticks);
        
        int len=matchsticks.length;
        if(len<4 || matchsticks[len-1]>edge) return false;
        
        return helper(matchsticks, new boolean[len], 0, 0, edge, 0);
    }
    
    private boolean helper(int[] nums, boolean[] visited, int edgeNum, int index, int target, int tempSum){
        if(edgeNum==4) return true;
        if(target==tempSum) return helper(nums, visited, edgeNum+1, 0, target, 0);
        if(tempSum>target) return false;
        
        for(int i=index; i<nums.length; i++){
            if(visited[i] || i>0 && !visited[i-1] && nums[i]==nums[i-1]) continue;
            
            visited[i]=true;
            if(helper(nums, visited, edgeNum, i+1, target, tempSum+nums[i])) return true;
            visited[i]=false;
        }
        return false;
    }
}//[3,3,3,3,5,5,5,5,4,4,4,4,]