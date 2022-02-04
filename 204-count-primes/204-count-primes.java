class Solution {
    public int countPrimes(int n) {
        if(n<3) return 0;
        
        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;
        int squrt=(int)Math.sqrt(n);
        
        for(int i=2; i<=squrt; i++){
            if(!isPrime[i]) continue;
            for(int j=i*i; j<n; j+=i){
                isPrime[j]=false;
            }
        }
        int ans=0;
        for(boolean b:isPrime){
            if(b==true) ans++;
        }
        return ans;
    }
}