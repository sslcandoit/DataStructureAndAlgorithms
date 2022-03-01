class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1=nums1.length, n2=nums2.length;
        Map<Integer, Integer> map=new HashMap<>();
        
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<n2; i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }  
            stack.push(nums2[i]);
        }
        for(int i=0; i<n1; i++){
            nums1[i]=map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}