class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> count=new HashMap<>();
        for(int a:arr) count.put(a, count.getOrDefault(a, 0)+1);

        long ans=0;
        for(int a:count.keySet()){
            for(int b:count.keySet()){
                int c=target-a-b;
                if(count.containsKey(c)){
                    long cnt1=count.get(a), cnt2=count.get(b), cnt3=count.get(c);
                    
                    if(a<b && b<c) ans+=cnt1*cnt2*cnt3;
                    else if(a==b && b==c) ans+=(cnt1)*(cnt1-1)*(cnt1-2)/6;
                    else if(a==b) ans+=(cnt1)*(cnt1-1)/2*cnt3;
                }
                ans%=1000000007;
            }
        }
        return (int)ans;
    }
}