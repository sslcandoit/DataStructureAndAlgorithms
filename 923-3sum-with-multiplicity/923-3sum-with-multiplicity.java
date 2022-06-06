class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long ans=0;
        for(int i=0; i<arr.length-2; i++){
            int low=i+1, up=arr.length-1;
            while(low<up){
                int sum=arr[i]+arr[low]+arr[up];
                if(sum<target) low++;
                else if(sum>target) up--;
                else{
                    int l=1, r=1;
                    while(low+l<up && arr[low+l]==arr[low]) l++;
                    while(low+l<=up-r && arr[up-r]==arr[up])  r++;
                    ans+=(arr[low]==arr[up]? (up-low+1)*(up-low)/2 : l*r);
                    low+=l;
                    up-=r;
                } 
                ans%=1000000007;     
            }
        }
        return (int)ans;
        /*
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
        return (int)ans;    */
    }
}