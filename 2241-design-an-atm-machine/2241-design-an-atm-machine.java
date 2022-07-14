class ATM {
    long[] bank;
    long[] denominations;
    public ATM() {
        this.bank=new long[5];
        this.denominations=new long[]{20, 50, 100, 200, 500};
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0; i<5; i++){
            this.bank[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans=new int[5];
        
        for(int i=4; i>=0; i--){
            if(amount>=this.denominations[i] && this.bank[i]>0){
                ans[i]=(int)Math.min(amount/this.denominations[i], this.bank[i]);
                amount-=(ans[i]*this.denominations[i]);
            }
        }
        if(amount >0) return new int[]{-1};
        
        for(int i=0; i<5; i++){
            this.bank[i]-=ans[i];
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */