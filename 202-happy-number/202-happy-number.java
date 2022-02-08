class Solution {
    public boolean isHappy(int n) {
       Set<Integer> set=new HashSet<>();
        while(!set.contains(n)){
            if(n==1) return true;
            set.add(n);
            int m=0;
            while(n !=0){
                int lastDigit=n%10;
                m+=lastDigit*lastDigit;
                n=n/10;
            }
            n=m;
        }
        return false;
    }
}