class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];
        
        int pre=0;
        for(int i=0; i<logs.size(); i++){
            String[] temp=logs.get(i).split(":");
            int id=Integer.parseInt(temp[0]);
            int time=Integer.parseInt(temp[2]);
            if(temp[1].equals("start")){
                if(!stack.isEmpty()){
                    int index=stack.peek();
                    ans[index]+=time-pre;
                }
                pre=time;
                stack.push(id);
            }else{
                int index=stack.pop();
                ans[index]+=time-pre+1;
                pre=time+1;
            } 
        }
        return ans;
    }
}