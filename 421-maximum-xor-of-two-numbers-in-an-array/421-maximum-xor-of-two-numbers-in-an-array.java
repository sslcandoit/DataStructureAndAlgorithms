class Solution {
    class Node{
        Node[] child=new Node[2];
    }
    public int findMaximumXOR(int[] nums) {
        Node root=new Node();
        for(int num:nums){
            Node cur=root;
            for(int i=31; i>=0; i--){
                int curBit=(num>>i)&1;
                if(cur.child[curBit]==null) cur.child[curBit]=new Node();
                cur=cur.child[curBit];
            }
        }
        int max=0;
        for(int num:nums){
            Node cur=root;
            int curSum=0;
            for(int i=31; i>=0; i--){
                int curBit=(num>>i)&1;
                if(cur.child[curBit^1] !=null) {
                    curSum+=(1<<i);
                    cur=cur.child[curBit^1];
                }else cur=cur.child[curBit];
            }
            max=Math.max(max, curSum);
        }
        return max;  
        /*
        int mask=0, ans=0;
        for(int i=31; i>=0; i--){
            mask=mask|(1<<i);
            
            Set<Integer> set=new HashSet<>();
            for(int num:nums) set.add(num&mask);
            
            int temp=ans|(1<<i);
            for(int n:set){
                if(set.contains(temp^n)){
                    ans=temp;
                    break;
                }
            }
        }
        return ans;*/
    }
}